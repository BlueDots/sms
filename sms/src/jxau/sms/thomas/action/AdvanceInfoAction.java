package jxau.sms.thomas.action;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import jxau.sms.commom.vo.PageVo;
import jxau.sms.thomas.advanceinfo.service.imple.AdvanceServiceImple;
import jxau.sms.thomas.vo.StuAdvVo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xml.internal.serialize.Printer;

@Controller  
@Scope("prototype") 
public class AdvanceInfoAction extends ActionSupport{

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		private AdvanceServiceImple advanceServiceImple;
		private StuAdvVo stuAdvVo;
		private String abstractId;
		private String filePath;
		private String outFilePath;
		private String flag;
		private int currentPage = 1;
		
		private PageVo pageVo = new PageVo();
		private Map<String, Object> session = ActionContext.getContext()
				.getSession();	// 获取strtus2的request
		@SuppressWarnings("unchecked")
		private Map<String, Object> request = (Map<String, Object>) ActionContext
				.getContext().get("request");
		private Map<String, Object> parameters = ActionContext.getContext()
				.getParameters();
		
		@Resource(name="advanceServiceImple")
		public void setAdvanceServiceImple(AdvanceServiceImple advanceServiceImple) {
			this.advanceServiceImple = advanceServiceImple;
		}
		
		public String showStuAdvInfo(){
			
			List<StuAdvVo> stuAdvVos = new ArrayList<StuAdvVo>();
			pageVo.setCurrentPage(currentPage);
			//System.out.print("currentPage==="+(String) parameters.get("currentPage"));
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("studentNo",stuAdvVo.getStudentNo());
			param.put("examState", stuAdvVo.getExamState());
			/*try {
				param.put("className",URLDecoder.decode(URLDecoder.decode(stuAdvVo.getClassName(),"utf-8"), "utf-8") );
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				return "error";
			}*/
			//param.put("studentName",stuAdvVo.getStudentName());
			stuAdvVos = advanceServiceImple.searchByAccurate(param, pageVo,0);
			request.put("listStuAdvVo",stuAdvVos);
			session.put("condition", param);
			ActionContext.getContext().put("pageVo", pageVo);
			return SUCCESS;
		}

		public String importFile(){
			
			System.out.print("flag==="+flag);
			List<StuAdvVo> stuAdvVos = new ArrayList<StuAdvVo>();
			//session.put("inputFlag", true);
			try {
				stuAdvVos = advanceServiceImple.getInputExcel(abstractId, stuAdvVos, filePath);
				request.put("inputStuAdvVos",stuAdvVos);
				if (flag.equals("true")) {
					System.out.print("导入成功");
					advanceServiceImple.inputExcel(stuAdvVos);
				}
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				return "error";
			}
			
			return SUCCESS;
		}
		public String exportFile(){
			String fileName = outFilePath+"学生评优评先表.xls";
			@SuppressWarnings("unchecked")
			Map conditions = (HashMap<String, Object>) session.get("condition");
			if (conditions==null) {
				return "error";
			}
			
			try {
				int flag = advanceServiceImple.exportExcel(fileName, abstractId, conditions);
				//int flag = advanceServiceImple.exportExcel(fileName,abstractId,stuAdvVos);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				return "error";
			}
			
			return SUCCESS;
		}
		public void setStuAdvVo(StuAdvVo stuAdvVo) {
			this.stuAdvVo = stuAdvVo;
		}
		
		public int getCurrentPage(){
			return currentPage;
		}
		public void setCurrentPage(int currentPage){
			this.currentPage = currentPage;
		}
		
		public String getAbstractId(){
			return abstractId;
		}
		public void setAbstractId(String abstractId){
			this.abstractId = abstractId;
		}

		public String getFilePath() {
			return filePath;
		}

		public void setFilePath(String filePath) {
			this.filePath = filePath;
		}
		
		public String getOutFilePath() {
			return outFilePath;
		}

		public void setOutFilePath(String outFilePath) {
			this.outFilePath = outFilePath;
		}
		public String getFlag() {
			return flag;
		}

		public void setFlag(String flag) {
			this.flag = flag;
		}

}
