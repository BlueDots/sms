package jxau.sms.thomas.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;

import jxau.sms.globalService.GlobalServiceInterface;
import jxau.sms.thomas.po.StuAdvInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype") 
public class AdvanceInfoAction extends ActionSupport {

		private GlobalServiceInterface globalServiceInterface;
		
		@Resource(name="advanceServiceImple")
		public void setGlobalServiceInterface(GlobalServiceInterface globalServiceInterface) {
			this.globalServiceInterface = globalServiceInterface;
		}
	
	
		private String studentNo;
		private Map<String, Object> request;
		
		//private ArrayList<StuAward> stuAwards;
		
		//private Map<String, Object> session;
		//private Map<String, Object> application;
		public AdvanceInfoAction(){
			request = (Map<String, Object>)ActionContext.getContext().get("request");
			//session = ActionContext.getContext().getSession();
			//application = ActionContext.getContext().getApplication();
		}
		
	
		public String execute(){
			
			//String studentNo = (String) request.get("condition");
			//AdvanceService advanceService = new AdvanceService();
			HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("studentNo", studentNo);
			System.out.print("学号参数是：" + studentNo);
			/*ArrayList<StuAdvInfo> stuAwards =  (ArrayList<StuAdvInfo>)globalServiceInterface.searchListByAccurate(params,0);
			System.out.print("学生个数："+ stuAwards.size());
			for (int i = 0; i < stuAwards.size(); i++) {
				System.out.print(stuAwards.get(i).getAdvanceActivity());
			}
		
			request.put("stuAwards", stuAwards);*/
			
			return SUCCESS;
		}
		
		public String getStudentNo() {
			return studentNo;
		}
	
		public void setStudentNo(String studentNo) {
			this.studentNo = studentNo;
		}
}