package jxau.sms.anping.service;

import java.util.List;
import java.util.Map;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import jxau.sms.anping.po.HosInsuranceInfo;
import jxau.sms.anping.po.ScholarShip;

import jxau.sms.commom.vo.PageVo;
import jxau.sms.commom.vo.WaitCheckVo;
import jxau.sms.lyx.po.RoleInfo;
import jxau.sms.lyx.po.TecBasicInfo;
import jxau.sms.qing.po.Teacher;

public interface ScholarShipService {
	public void addSchloarShip(List<ScholarShip> scholarShips,TecBasicInfo teacher,List<RoleInfo> roleInfos,String college,String className,String term);

	public void exportSchloarShip(POIFSFileSystem excelFileSystem,TecBasicInfo teacher,List<RoleInfo> roleInfos,String college,String className,String term);

	public void updateSchloarShip(List<ScholarShip> scholarShips,TecBasicInfo teacher,List<RoleInfo> roleInfos);

	public List<ScholarShip> Search(Map<String, Object> param,
			PageVo pageVo, int type);

	public List<ScholarShip> searchOneStudent(String studentNo);
 
	public  ScholarShip  searchOneByTerm(String studentNo,
			String term);
	
	public List<WaitCheckVo>  getAllWaitCheckData(List<RoleInfo> infos,TecBasicInfo teacher);
	 
	
	public List<ScholarShip> queryByGaoJi(Map<String,Object> params,PageVo pagevo);
	
	public List<ScholarShip> searchOneClassByOneStudent(String studentNo,PageVo pagevo,String term);
 
}
