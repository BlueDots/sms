package jxau.sms.anping.scholarship.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.stereotype.Service;

import jxau.sms.abstration.AbstractionService;
import jxau.sms.anping.po.HosInsuranceInfo;
import jxau.sms.anping.po.ScholarShip;
import jxau.sms.anping.service.ScholarShipService;
import jxau.sms.commom.vo.PageVo;
import jxau.sms.globaldao.Dao;
 
/**
 * 　班级奖学金service类
 * 　
 * 	　需要提供的方法有这些：
 * 		１。添加班级奖学金数据(包括批量添加／导入)　[当然该操作需要经过权限模块，在action中自动屏蔽那些没有权限的教师，
 * 　　　　　　但是service层需要做一个特例的排段的是对班主任的判断，如果他的最高的角色是班主任的话，那么他只能够导入自己班级的信息，
 * 		　　　其他人只要有这个权限就随便导入。然后就是一些业务逻辑的判断		
 * 　　　　]
 * 		２。更新学生信息[也是如上，只是需要做一个班主任的判断,然后是其他的业务逻辑的判断]
 * 		3.学生可以导出班级中所有的班级奖学金信息[需要判断学生是自己的班级的，使用赖慧强封装的库]
 * 		4.普通查询和高级查询
 * 		５。审核，使用陈江封装的库
 * 		６。查询某个学生的所有的信息[找出某个学生在校的所有班级奖学金情况]
 * 		
 * @author anping
 * 2014-4-21
 * TODO
 */
@Service("scholarShip")
public class ScholarShipServiceImpl extends AbstractionService implements ScholarShipService {

	

		/**
		 * 添加
		 * 需要处理的业务逻辑如下
		 * 	　１。学号不能为空
		 *  　2。学号不能重复[采用学院班级比较studentNo的方式插入]
		 *   ３。其他的成绩部分能为空，但四部分中总分不能为空
		 *   ４。自动的计算总分
		 *    
		 *   ６。统一计算总分排名
		 *   ７。统一计算奖学金排名(拿取班级可拿奖的人数)
		 */
	@Override
	public void addSchloarShip(List<ScholarShip> scholarShips,String term) {
		
		 
	}

	@Override
	public void exportSchloarShip(POIFSFileSystem excelFileSystem,String term) {
		 
	}

	/**
	 * 更新的业务逻辑如下：
	 * 　 1. 只能更新四部分中的成绩
	 *  　2. 自动的计算总分
	 *   
	 *    ４。统一计算总分排名
	 *    ５。统一计算奖学金排名(...)
	 */
	@Override
	public void updateSchloarShip(List<ScholarShip> scholarShips) {
		 
		
	}

	@Override
	public List<HosInsuranceInfo> Search(Map<String, Object> param,
			PageVo pageVo, int type) {
	 
		return null;
	}

	@Override
	public List<HosInsuranceInfo> searchOneStudent(String studentNo
			 ) {
		 
		return null;
	}
	
	@Override
	public <T> List<T> getWaitingForLists(Map<String, Object> params,
			PageVo pageVo) {
		 return null;
	}
	
	 
	/**
	 * 
	 * anping
	 * TODO计算学生总分的所有排名
	 * 
	 * 　首先从数据库中获取所有班级的数据,默认以总分的降序排序，没有并列第一的情况
	 * 		如果总分相同，那么我先已智育的排序，再以德育排序，再以美育，再以体育
	 * 	　如果全部相同就数据库随机()
	 * 	　　然后就直接将排好序的成绩表明排名，入库
	 * 　　可以通过sql语句的存储过程中的游标来实现
	 * 下午10:53:32
	 */
	private  void doTotalScoreRank(String college,String className,String term){
		Map<String,Object>  params = new HashMap<String,Object>(3);
		params.put("college",college);
		params.put("className", className);
		params.put("term", term);
		dao.select(namespace+"updateTotalScoreRand", params);
	}
	/**
	 * 
	 * anping
	 * TODO计算获奖情况　需要获取班级的比例分配情况
	 * 下午10:54:32	首先从数据库中获取所有的班级信息的排名和备注的数据
	 * 				然后获取该班被分配的比例数据
	 * 				然后通过遍历是否有挂科情况来分派班级的奖学金
	 * @param college
	 * @param className
	 */
	private void doAwardRand(String college,String className){
		
	}
	
	@Override
	public ScholarShip searchOneByTerm(String studentNo, String term) {
		 Map<String,Object> params  = new HashMap<String,Object>(2);
		 params.put("studentNo", studentNo);
		 params.put("term",term);
		 return dao.selectOne(namespace+"selectSchloarShipByTermAndStudentno", params);
	}

	
	
	/**
	 * 判断奖学金中部分属性是不是为null
	 * anping
	 * 比如　学号不能为null 
	 * 		基准分奖励分惩罚分中基准分不能为null
	 * 		学业课程分不能为null
	 * 		体育课程（活动）分要么一个为null要么全部不为null
	 * TODO
	 * 上午10:58:49
	 * @return
	 */
	public boolean checkScholarIsNull(List<ScholarShip> scholars){
	 
		boolean flag = false;
		boolean flag2 = false;
		
		for(ScholarShip scholarShip:scholars){
			if(scholarShip.getStudent()==null ||scholarShip.getStudent().getStudentNo()==null){
				return false;
			}
			if(scholarShip.getBaseScore()==0){
				return false;
			}
			
			if(scholarShip.getLessonScore()==0){
				return false;
			}
			if(!flag && scholarShip.getSportScore()==0){
				flag=true;
			}
			if(flag && scholarShip.getSportScore()!=0){
				return false;
			}
			
			if(!flag2&& scholarShip.getSportScore()>0){
				flag2=true;
			}
			
			if(flag2 && scholarShip.getSportScore()==0){
				return false;
			}
			
		}
		return true;
	}
	 
	private Dao dao ;
	@Resource(name="dao")
 	public void setDao(Dao dao) {
		this.dao = dao;
	}
	private String namespace="jxau.sms.anping.scholarship.dao.";
	
}
