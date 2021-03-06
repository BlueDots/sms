package jxau.sms.lyx.purview.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import jxau.sms.lyx.po.PurviewInfo;
import jxau.sms.lyx.util.ArrayTypeConversion;

/**
 * 
 * @author lyx
 * 2014-4-14
 * TODO:
 * 		该类用于用户或角色分配权限模块
 * 		从action获取页面数据后进行集合增删处理操作
 */

@Service("PurviewListPackage")
public class PurviewListPackage {

	private UserPurviewManagerServiceImpl upms;
	private UserHandlePurview uhp;
	private RoleHandlePurview rhp;
	
	@Resource(name="UserHandlePurview")
	public void setUhp(UserHandlePurview uhp) {
		this.uhp = uhp;
	}

	@Resource(name="RoleHandlePurview")
	public void setRhp(RoleHandlePurview rhp) {
		this.rhp = rhp;
	}

	@Resource(name="UserPurviewManagerServiceImpl")
	public void setUpms(UserPurviewManagerServiceImpl upms) {
		this.upms = upms;
	}
	
	/**
	 * 该方法返回一个int型集合，里面存放了
	 * 某用户或某角色的所有权限id
	 * 
	 */
	public List<Integer> receiveOldList(Map<String,Object> mapCondition,int status){
		
		List<Integer> oldList = new ArrayList<Integer>();

		//调用方法获取权限
		List<PurviewInfo> checkList = upms.searchListByAccurate(mapCondition, status);
		
		for(int i=0;i<checkList.size();i++){
			oldList.add(checkList.get(i).getId());		
		}
		
		return oldList;
	}
	
	public void containerTransform(String number,String param){
		
		//获取原先的集合
			Map<String,Object> map = new HashMap<String,Object>();
			
			if(number.length()==4){
				map.put("teacherNo",number);
			}else if(number.length()<4){
				map.put("roleNo",number);
			}
			
			List<Integer> oldList = receiveOldList(map,0);
						
		//获取页面信息	
			String purviewUrl[] = param.split(",");
			List<Integer> newList = new ArrayList<Integer>();
			
			newList= ArrayTypeConversion.StringConversionInteger(purviewUrl);			
			
		//集合迭代比较增删处理
			
			for(Iterator<Integer> iterator=oldList.iterator();iterator.hasNext();){
				
				int id = iterator.next();
				//
				if(newList.contains(id)){
					iterator.remove();
					newList.remove(new Integer(id));						
				}	
			}
			
		//调用方法
		HandlePurviewPackage(number,newList,oldList);
			
	}
	
	/**
	 * 
	 * lyx
	 * TODO
	 * 下午7:39:44
	 * @param number:角色编号或教师编号
	 * @param newList：待插入的权限id
	 * @param oldList:		待删除的权限id
	 */
	public void HandlePurviewPackage(String number,List<Integer> newList,List<Integer> oldList){
		
		//传入的是教师编号
		if(number.length()==4){
			
			uhp.handleAllocationPurview(number, newList, oldList);
			
		//传入的是角色编号
		}else if(number.length()<4){
			
			rhp.handleAllocationPurview(number, newList, oldList);
			
		}		
	}
	
}
