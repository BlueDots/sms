package jxau.sms.thomas.util;

import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import jxau.sms.commom.vo.PropVo;
import jxau.sms.globaldao.Dao;

public class PropHandler {
	
	private PropVo propVo;
	private Dao dao;
	
	public PropHandler(PropVo propVo){
		this.propVo = propVo;
	}
	
	@Resource(name="dao")
	public void setDao(Dao dao){
		this.dao = dao;
	}
	
	public boolean CheckProporation(){
		
		boolean flag = true;
		HashMap<String, Object> params = new HashMap<>();
		if(propVo.getLevel() == 0){
			//List<SchPropDistribution> = dao.select()
		}else{
			
		}
		
		return false;
	}
}
