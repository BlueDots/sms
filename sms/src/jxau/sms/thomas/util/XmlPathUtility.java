/**
* @package_name   com.stuManSys.utility
* @file_name XmlPathUtility.java
* @author Administrator
* @date 2014-3-16
*/

package jxau.sms.thomas.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/** 
 * @ClassName: XmlPathUtility
 * @Description: TODO
 */
/**
 * @author Administrator
 *
 */
public class XmlPathUtility {

	public static String getPath(String fileName,String page){
		String filepath = Thread.currentThread().getClass().getResource("/"+page).getPath() + "/" + fileName;
		filepath = filepath.replaceAll("%20", " ");
        try {
			filepath = URLDecoder.decode(filepath, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(XmlPathUtility.class.getName()).log(Level.ERROR,"文件路径解析错误", e); 
		} 
        return filepath;
	}
}
