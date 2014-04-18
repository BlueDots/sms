package jxau.sms.thomas.util;

import java.util.HashMap;

public class MapperUtility {

	private static HashMap<String, String> mapperIds;
	private static final String fileName = "AbstractionMapper.xml";
	
	public static String getMapperId(String viewId,String mapperId){
		String mapperid = null;
		mapperIds = XmlHandler.iterateTree(fileName, viewId);
		for (java.util.Map.Entry<String, String> mapper:mapperIds.entrySet()) {
			if (mapper.getKey().equals(mapperId)) {
				mapperid = mapper.getValue();
			}
		}
		return mapperid;
	}
	
}
