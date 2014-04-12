package jxau.sms.anping.po;

import java.util.Date;

import jxau.sms.chenjiang.stuBasicInfo.po.StuBasicInfo;

public class HosInsuranceInfo {
	private int no;//编号
	private StuBasicInfo student;//学号
	private int sex;//性别
	private String type;//类型
	private String hospitaladdress;//住院地址
	private Date hospitalDate;//住院日期
	private Date leavedate;//出院日期
	private int date;//住院天数
	private int localcity;//本市还是转外
	private String conditon;//病情
	private double cost;//总费用
	private Date applytime;//申请时间
	private int accept;//是否受理
	private int collarCard;//是否领卡
	private Date submittime;//递交案子时间
	private Date refusereason;//未受理原因
	private String result;//处理结果
	private String companyRemark;//商业保险备注
	private double reimbursementamount;//医保处已报金额
	private int bill;//是否有结算单
	private Date getcardtime;//领卡时间
	private String jumingRemark;//居民医保备注
	private String bankcardID;//银行卡号
	private int complete;//除结算单材料是否齐全
	private Date insurertime;//保险公司接案子的时间
	private String notinsurerreason;//没有结算的原因
	private String baoxiaoRemark;//已报销备注
	private String stateRemark;//审核状态备注
	private String returnMark;//返回消息备注
	private int hosState;//审核状态
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}

	public StuBasicInfo getStudent() {
		return student;
	}
	public void setStudent(StuBasicInfo student) {
		this.student = student;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHospitaladdress() {
		return hospitaladdress;
	}
	public void setHospitaladdress(String hospitaladdress) {
		this.hospitaladdress = hospitaladdress;
	}
	public Date getHospitalDate() {
		return hospitalDate;
	}
	public void setHospitalDate(Date hospitalDate) {
		this.hospitalDate = hospitalDate;
	}
	public Date getLeavedate() {
		return leavedate;
	}
	public void setLeavedate(Date leavedate) {
		this.leavedate = leavedate;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getLocalcity() {
		return localcity;
	}
	public void setLocalcity(int localcity) {
		this.localcity = localcity;
	}
	public String getConditon() {
		return conditon;
	}
	public void setConditon(String conditon) {
		this.conditon = conditon;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public Date getApplytime() {
		return applytime;
	}
	public void setApplytime(Date applytime) {
		this.applytime = applytime;
	}
	public int getAccept() {
		return accept;
	}
	public void setAccept(int accept) {
		this.accept = accept;
	}
	public int getCollarCard() {
		return collarCard;
	}
	public void setCollarCard(int collarCard) {
		this.collarCard = collarCard;
	}
	public Date getSubmittime() {
		return submittime;
	}
	public void setSubmittime(Date submittime) {
		this.submittime = submittime;
	}
	public Date getRefusereason() {
		return refusereason;
	}
	public void setRefusereason(Date refusereason) {
		this.refusereason = refusereason;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getCompanyRemark() {
		return companyRemark;
	}
	public void setCompanyRemark(String companyRemark) {
		this.companyRemark = companyRemark;
	}
	public double getReimbursementamount() {
		return reimbursementamount;
	}
	public void setReimbursementamount(double reimbursementamount) {
		this.reimbursementamount = reimbursementamount;
	}
	public int getBill() {
		return bill;
	}
	public void setBill(int bill) {
		this.bill = bill;
	}
	public Date getGetcardtime() {
		return getcardtime;
	}
	public void setGetcardtime(Date getcardtime) {
		this.getcardtime = getcardtime;
	}
	public String getJumingRemark() {
		return jumingRemark;
	}
	public void setJumingRemark(String jumingRemark) {
		this.jumingRemark = jumingRemark;
	}
	public String getBankcardID() {
		return bankcardID;
	}
	public void setBankcardID(String bankcardID) {
		this.bankcardID = bankcardID;
	}
	public int getComplete() {
		return complete;
	}
	public void setComplete(int complete) {
		this.complete = complete;
	}
	public Date getInsurertime() {
		return insurertime;
	}
	public void setInsurertime(Date insurertime) {
		this.insurertime = insurertime;
	}
	public String getNotinsurerreason() {
		return notinsurerreason;
	}
	public void setNotinsurerreason(String notinsurerreason) {
		this.notinsurerreason = notinsurerreason;
	}
	public String getBaoxiaoRemark() {
		return baoxiaoRemark;
	}
	public void setBaoxiaoRemark(String baoxiaoRemark) {
		this.baoxiaoRemark = baoxiaoRemark;
	}
	public String getStateRemark() {
		return stateRemark;
	}
	public void setStateRemark(String stateRemark) {
		this.stateRemark = stateRemark;
	}
	public String getReturnMark() {
		return returnMark;
	}
	public void setReturnMark(String returnMark) {
		this.returnMark = returnMark;
	}
	public int getHosState() {
		return hosState;
	}
	public void setHosState(int hosState) {
		this.hosState = hosState;
	}
	
	
	
}
