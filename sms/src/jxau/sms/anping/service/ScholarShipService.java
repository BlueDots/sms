package jxau.sms.anping.service;

import java.util.List;
import java.util.Map;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import jxau.sms.anping.po.HosInsuranceInfo;
import jxau.sms.anping.po.ScholarShip;

import jxau.sms.commom.vo.PageVo;
import jxau.sms.lyx.po.RoleInfo;
import jxau.sms.lyx.po.TecBasicInfo;

public interface ScholarShipService {
	public void addSchloarShip(List<ScholarShip> scholarShips,TecBasicInfo teacher,List<RoleInfo> roleInfos,String college,String className,String term);

	public void exportSchloarShip(POIFSFileSystem excelFileSystem,TecBasicInfo teacher,List<RoleInfo> roleInfos,String college,String className,String term);

	public void updateSchloarShip(List<ScholarShip> scholarShips,TecBasicInfo teacher,List<RoleInfo> roleInfos);

	public List<HosInsuranceInfo> Search(Map<String, Object> param,
			PageVo pageVo, int type);

	public List<HosInsuranceInfo> searchOneStudent(String studentNo);
 
	public  ScholarShip  searchOneByTerm(String studentNo,
			String term);
 
}
