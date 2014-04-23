package jxau.sms.thomas.action;


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

@Controller  
@Scope("prototype") 
public class AdvanceInfoAction extends ActionSupport{

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		private AdvanceServiceImple advanceServiceImple;
		private StuAdvVo stuAdvVo;
		private int currentPage;
		private PageVo pageVo = new PageVo();
		private Map<String, Object> session = ActionContext.getContext()
				.getSession();	// 获取strtus2的request
		@SuppressWarnings("unchecked")
		private Map<String, Object> request = (Map<String, Object>) ActionContext
				.getContext().get("request");
		
		@Resource(name="advanceServiceImple")
		public void setAdvanceServiceImple(AdvanceServiceImple advanceServiceImple) {
			this.advanceServiceImple = advanceServiceImple;
		}
		
		public String showStuAdvInfo(){
			
			List<StuAdvVo> stuAdvVos = new ArrayList<StuAdvVo>();
			pageVo.setCurrentPage(currentPage);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("studentNo",stuAdvVo.getStudentNo());
			stuAdvVos = advanceServiceImple.searchByAccurate(param, pageVo,0);
			//param.put("studentNo", stuAdvVo.get(0).getStudentNo());
			request.put("listStuAdvVo",stuAdvVos);
			ActionContext.getContext().put("pageVo", pageVo);
			return SUCCESS;
			
		}
		
		public void setStuAdvVo(StuAdvVo stuAdvVo) {
			this.stuAdvVo = stuAdvVo;
		}
		
		public void setCurrentPage(int currentPage){
			this.currentPage = currentPage;
		}

}
