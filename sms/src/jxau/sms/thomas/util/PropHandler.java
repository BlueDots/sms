package jxau.sms.thomas.util;

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
	
	public boolean generateProp(){
		boolean flag = true;
		long totalNumber = 1;
		if (propVo.getNumbers()!=null&&propVo.getLevel()==1) {	//校级输入人数
			
		}else {		//院级输入比例
			
		}
		if (propVo.getNumbers()!=null&&propVo.getLevel()==0) {	//院级输入人数
			
		}else{		//院级输入比例
			
		}
			
		return flag;
	}
	public boolean CheckProporation(List<Double> props){
		
		
		return false;
	}
}