package jxau.sms.util.service.impl;

import java.util.List;
import java.util.Map;

import jxau.sms.anping.po.ClassInfo;
import jxau.sms.anping.po.DepInfo;
import jxau.sms.anping.po.MajorInfo;
import jxau.sms.commom.vo.PageVo;
import jxau.sms.globalService.GlobalServiceInterface;
import jxau.sms.lyx.po.RoleInfo;
import jxau.sms.lyx.po.TecBasicInfo;

public interface CollegeMajorClassInterface  extends GlobalServiceInterface{
    /**
     * 通过教师登陆信息的最高角色来拿到所管辖的部门
     * anping
     * TODO
     * 下午4:23:36
     * @param teacher　教师基本信息
     * @param role　　　教师角色
     * @return　　部门学院信息
     */
	public List<DepInfo> searchCollegeByTeacher(TecBasicInfo teacher,List<RoleInfo> roles);
	/**
	 * 通过教师登陆信息的最高角色来拿到所管辖的方向
	 * anping
	 * TODO
	 * 下午4:35:06
	 * @param teacher  教师基本信息
	 * @param role　　　　教师角色
	 * @param departNo　　可选（如果是班主任可不写，其他必写）
	 * @return　　专业方向信息
	 */
	public List<MajorInfo> searchMajorByTeacher(TecBasicInfo teacher,List<RoleInfo> roles,String departNo);
	/**
	 * 通过教师登陆信息的最高角色来拿到所管辖的班级
	 * anping
	 * TODO
	 * 下午4:37:33
	 * @param teacher 教师基本信息
	 * @param role　　　教师角色
	 * @param departNo　 可选　如果提供了majorNo 则可为null
	 * @param majorNo　　　可选(提供departNo时才能为null)
	 * @return　班级信息
	 */
	public List<ClassInfo> searchClassByTeacher(TecBasicInfo teacher,List<RoleInfo> roles,String departNo,String majorNo);

	/**
	 * 得到学院list
	 * 江
	 * TODO
	 * 下午12:42:58
	 * @param pageVo 分页 page为null时，默认得到第一页的数据
	 * @param status  级别 0,代表只能开到state为0的数据,即激活状态的数据,级别1，可以得到所有状态的数据
	 * @return
	 */
	public  List<DepInfo> getCollegeLists(Map<String, Object> params,int status,PageVo pageVo);
	
	/**
	 * 得到专业list
	 * 江
	 * TODO
	 * 下午12:42:58
	 * @param pageVo 分页 page为null时，默认得到第一页的数据
	 * @param status  级别 0,代表只能开到state为0的数据,即激活状态的数据,级别1，可以得到所有状态的数据
	 * @return
	 */
	public  List<MajorInfo> getMajorLists(Map<String, Object> params,int status,PageVo pageVo) ;
	/**
	 * 得到班级list
	 * 江
	 * TODO
	 * 下午12:42:58
	 * @param pageVo 分页 page为null时，默认得到第一页的数据
	 * @param status  级别 0,代表只能开到state为0的数据,即激活状态的数据,级别1，可以得到所有状态的数据
	 * @return
	 */
	public  List<ClassInfo> getClassLists(Map<String, Object> params,int status,PageVo pageVo) ;
}
