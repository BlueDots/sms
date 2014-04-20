package jxau.sms.anping.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import jxau.sms.anping.po.HosInsuranceInfo;
import jxau.sms.anping.service.YiBaoService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class YiBaoActionByAJAX extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 通过医保的编号去拿医保的信息 anping TODO 下午4:31:08
	 * 
	 * @return
	 */
	public String getHosByHosNo() {
		String[] hosNos = (String[]) parameters.get("hosNo");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("hosNo", Integer.parseInt(hosNos[0]));

		try {
			hosInsuranceInfo = yiBaoService.searchByAccurate(param, -1);
			System.out.println(hosInsuranceInfo.getStudent().getStudentNo());
		} catch (Exception e) {
			e.printStackTrace();

		}
		return SUCCESS;
	}

	@Resource(name = "yiBaoService")
	public void setYiBaoService(YiBaoService yiBaoService) {
		this.yiBaoService = yiBaoService;
	}

	private YiBaoService yiBaoService;

	public HosInsuranceInfo getHosInsuranceInfo() {
		return hosInsuranceInfo;
	}

	private HosInsuranceInfo hosInsuranceInfo = new HosInsuranceInfo();
	// 获取strtus2 的参数
	private Map<String, Object> parameters = ActionContext.getContext()
			.getParameters();
}
