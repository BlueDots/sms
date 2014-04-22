package jxau.sms.util.chenjiang.roleVerify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import jxau.sms.globaldao.Dao;
import jxau.sms.util.chenjiang.exception.ParamWrongException;


@Component("moduleVerifyOperation")
public class ModuleVerifyOperation {
	private Dao dao;
	
	@Resource(name="dao")
	public void setDao(Dao dao) {
		this.dao = dao;
	}

	@SuppressWarnings("unchecked")
	public <T>  void moduleVerify(List<T> ids,String exameState,Object remarks,String moduleId,ModuleVerify mVerify) {

		if(ids == null)
			throw new ParamWrongException("参数ids不能为空!");
		//一条记录一条的remarks
		List<String> remarkLists = null;
		//所有记录都是一样的remarks
		//记录实体
		List<ModuleVerifyAndData> moduleVerifyAndDatas = new ArrayList<>();
		String remarksString = null;
		if(remarks == null) remarksString="";
		else {
			if(remarks instanceof String) {
				remarksString = (String) remarks;
			}
			else if(remarks instanceof List<?>) {
				
				remarkLists = (List<String>)remarks;
				
				if(remarkLists.size() != ids.size())
					throw new ParamWrongException("参数remarks为List<String>时，size()必须与List<T> ids的size()一样");
			}
			else {
				throw new ParamWrongException("参数remarks要么为null，要么为String，要么为List<String>");
			}
		}
		
		if(remarkLists != null) {//一条记录一条remarks
			for(int i=0;i<ids.size();i++) {
				ModuleVerifyAndData m = new ModuleVerifyAndData();
				m.setExameState(exameState);
				m.setId(ids.get(i));
				m.setModuleVerify(mVerify);
				m.setRemark(remarkLists.get(i));
				moduleVerifyAndDatas.add(m);
			}
		}
		else {//所有记录共同
			for(int i=0;i<ids.size();i++) {
				ModuleVerifyAndData m = new ModuleVerifyAndData();
				m.setExameState(exameState);
				m.setId(ids.get(i));
				m.setModuleVerify(mVerify);
				m.setRemark(remarksString);
				moduleVerifyAndDatas.add(m);
			}
		}

		dao.batchUpdate("jxau.sms.util.chenjiang.roleVerify.verify", moduleVerifyAndDatas);
	}
	
	/**
	 * 得到待审核人数
	 * @param params
	 * @return
	 */
	public int getRoleWaitForVerifyNums(Map<String, Object> params) {
		if(params == null)
			throw new ParamWrongException("参数params不能为空!");
		int num = -1;
		dao.selectOne("jxau.sms.util.chenjiang.roleVerify.getVerifyNums", params);
		
		num = (Integer)params.get("nums");
		
		return num;
	}
	
}
