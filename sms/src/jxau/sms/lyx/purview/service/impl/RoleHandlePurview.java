package jxau.sms.lyx.purview.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import jxau.sms.lyx.po.RolePurview;

/**
 * 
 * @author lyx
 * 2014-4-14
 * TODO:
 * 		 对角色分配权限的处理
 */

@Service("RoleHandlePurview")
public class RoleHandlePurview implements AllocationPurviewStandard {

	private UserPurviewManagerServiceImpl upms;
	
	@Resource(name="UserPurviewManagerServiceImpl")
	public void setUpms(UserPurviewManagerServiceImpl upms) {
		this.upms = upms;
	}

	//角色权限增删操作
	@Override
	public void handleAllocationPurview(String number, List<Integer> newList,
			List<Integer> oldList) {
		// TODO Auto-generated method stub
		
		List<RolePurview> insertRolePurview = new ArrayList<RolePurview>();
		List<RolePurview> deleteRolePurview = new ArrayList<RolePurview>();
		
		logicJudgment(RolePurview.class,insertRolePurview,deleteRolePurview,newList,oldList,number);
		
	}

	@SuppressWarnings("hiding")
	@Override
	public <RolePurview> void logicJudgment(Class RolePurview,List<RolePurview> insertList, List<RolePurview> deleteList,List<Integer> newList,List<Integer> oldList,String number){
		// TODO Auto-generated method stub
		
		if(newList.size()!=0){			
				for(int i=0;i<newList.size();i++){
					jxau.sms.lyx.po.RolePurview rp;
					try {
						rp = (jxau.sms.lyx.po.RolePurview) RolePurview.newInstance();
						rp.setRoleNo(Integer.parseInt(number));
						rp.setPurviewNo(newList.get(i));
						insertList.add((RolePurview) rp);
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			
				}	
		}
			
		System.out.println("---------------------");
		
		if(oldList.size()!=0){	
				for(int i=0;i<oldList.size();i++){
					jxau.sms.lyx.po.RolePurview rp;
					try {
						rp = (jxau.sms.lyx.po.RolePurview) RolePurview.newInstance();
						rp.setRoleNo(Integer.parseInt(number));
						rp.setPurviewNo(oldList.get(i));
						deleteList.add((RolePurview) rp);
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
				}
		}	

		MapPutList(insertList,deleteList);
		
	}
	
	public <RolePurview> void MapPutList(List<RolePurview> insertList,List<RolePurview> deleteList){
				
		HashMap<String,Object> insertMap = new HashMap<String,Object>();
		HashMap<String,Object> deleteMap = new HashMap<String,Object>();

		
		if(!(insertList.isEmpty())){
			insertMap.put("addRolePurviewList",insertList);
		}
		
		if(!(deleteList.isEmpty())){
			deleteMap.put("delRolePurviewList",deleteList);
		}
				
		upms.renewAllocationPurview(insertMap, deleteMap);
		
	}
	

}
