package jxau.sms.lyx.purview.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import jxau.sms.lyx.po.PurviewInfo;

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
}
