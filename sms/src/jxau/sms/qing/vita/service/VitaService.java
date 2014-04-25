package jxau.sms.qing.vita.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import jxau.sms.globaldao.Dao;
import jxau.sms.qing.po.Advance;
import jxau.sms.qing.po.Participate;
import jxau.sms.qing.po.Student;
import jxau.sms.qing.vita.vo.VitaVo;


import org.springframework.stereotype.Service;

@Service("vitaService")
public class VitaService {
	private Dao dao;	
	@Resource(name="dao")
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	public VitaVo VitaInfo(String studentNo){
		VitaVo vitaVo = new VitaVo();
		//填写基本信息
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("studentNo", studentNo);
		vitaVo.setStudentInfo((Student)dao.selectOne("jxau.sms.qing.login.dao.selectStudentBasicInfo", map));
		//学生活动
		Participate p = dao.selectOne("jxau.sms.qing.participate.dao.selectParticipate",map);	
		vitaVo.setParticipate(p);
		System.out.println(p.getActivityName());
		//评优评先  & 奖助学金 
		List<Advance> list ;
		list = dao.select("jxau.sms.qing.advance.dao.selectAdvance",map);						
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getActivityName());
		}
		vitaVo.setAdvance(list);
		return vitaVo;
	}

}
