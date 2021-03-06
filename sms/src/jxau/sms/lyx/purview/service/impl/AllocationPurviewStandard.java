package jxau.sms.lyx.purview.service.impl;

import java.util.List;


/**
 * 
 * @author lyx
 * 2014-4-14
 * TODO:
 * 		该接口用于对某用户或某角色分配权限的抽象定标准
 */
public interface AllocationPurviewStandard {

	public void handleAllocationPurview(String number,List<Integer> newList,List<Integer> oldList);

	public  <T>  void logicJudgment(Class T,List<T>  insertList,List<T> deleteList,List<Integer> newList,List<Integer> oldList,String number);

}
