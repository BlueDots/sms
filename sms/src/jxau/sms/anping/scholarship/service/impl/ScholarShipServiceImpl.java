package jxau.sms.anping.scholarship.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import jxau.sms.abstration.AbstractionService;
import jxau.sms.anping.po.HosInsuranceInfo;
import jxau.sms.anping.po.ScholarShip;
import jxau.sms.anping.service.ScholarShipService;
import jxau.sms.commom.vo.PageVo;
 
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
public class ScholarShipServiceImpl extends AbstractionService implements ScholarShipService {

	

	
	
		/**
		 * 添加
		 * 需要处理的业务逻辑如下
		 * 	　１。学号不能为空
		 *  　2。学号不能重复[采用学院班级比较studentNo的方式插入]
		 *   ３。其他的成绩部分能为空，但四部分中总分不能为空
		 *   ４。自动的计算总分
		 *   ５。统一添加完之后，计算班级的四部分成绩排名
		 *   ６。统一计算总分排名
		 *   ７。统一计算奖学金排名(拿取班级可拿奖的人数)
		 */
	@Override
	public void addSchloarShip(List<ScholarShip> scholarShips) {
		 
	}

	@Override
	public void exportSchloarShip(POIFSFileSystem excelFileSystem) {
		 
	}

	/**
	 * 更新的业务逻辑如下：
	 * 　 1. 只能更新四部分中的成绩
	 *  　2. 自动的计算总分
	 *    3. 统一修改完之后，计算班级的四部分的成绩排名
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
	public List<HosInsuranceInfo> searchOneStudentByTerm(String studentNo,
			String term, PageVo pageVo) {
		 
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
	 * TODO计算班级奖学金的排名
	 * 下午10:52:12
	 * @param college　　学院
	 * @param className　班级
	 */
	private void doFourPartRank(String college,String className){
		
	}
	/**
	 * 
	 * anping
	 * TODO计算学生总分的所有排名
	 * 下午10:53:32
	 */
	private void doTotalScoreRank(String college,String className){
		
	}
	/**
	 * 
	 * anping
	 * TODO计算获奖情况　需要获取班级的比例分配情况
	 * 下午10:54:32
	 * @param college
	 * @param className
	 */
	private void doAwardRand(String college,String className){
		
	}

	@Override
	public <T> int roleEntry(Class<?> c, Object entryObject, String moduleId,
			String roleId, String level) {
		// TODO Auto-generated method stub
		return 0;
	}

}
