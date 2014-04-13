package jxau.sms.anping.po;



import java.util.Date;

import jxau.sms.chenjiang.po.StuBasicInfo;

public class HosInsuranceInfo {
	private int hosNo;//编号
	private StuBasicInfo student;//学号

	private String hosType;//类型
	private String hospitalAddress;//住院地址
	private Date hospitalDate;//住院日期
	private Date leaveDate;//出院日期
	private int hosDate;//住院天数
	private int localCity;//本市还是转外
	private String conditon;//病情
	private double cost;//总费用
	private Date applyTime;//申请时间
	private int accept;//是否受理
	private int collarCard;//是否领卡
	private Date submitTime;//递交案子时间
	private String refuseReason;//未受理原因
	private String resultDeal;//处理结果
	private String companyRemark;//商业保险备注
	private double reimbursementAmount;//医保处已报金额
	private int bill;//是否有结算单
	private Date getcardTime;//领卡时间
	private String jumingRemark;//居民医保备注
	private String bankcardID;//银行卡号
	private int complete;//除结算单材料是否齐全
	private Date insurerTime;//保险公司接案子的时间
	private String notinsurerReason;//没有结算的原因
	private String baoxiaoRemark;//已报销备注
	private String stateRemark;//审核状态备注
	private String returnMark;//返回消息备注
	private String hosState;//审核状态
	public int getHosNo() {
		return hosNo;
	}
	public void setHosNo(int hosNo) {
		this.hosNo = hosNo;
	}
	public StuBasicInfo getStudent() {
		return student;
	}
	public void setStudent(StuBasicInfo student) {
		this.student = student;
	}
	public String getHosType() {
		return hosType;
	}
	public void setHosType(String hosType) {
		this.hosType = hosType;
	}
	public String getHospitalAddress() {
		return hospitalAddress;
	}
	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}
	public Date getHospitalDate() {
		return hospitalDate;
	}
	public void setHospitalDate(Date hospitalDate) {
		this.hospitalDate = hospitalDate;
	}
	public Date getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}
	public int getHosDate() {
		return hosDate;
	}
	public void setHosDate(int hosDate) {
		this.hosDate = hosDate;
	}
	public int getLocalCity() {
		return localCity;
	}
	public void setLocalCity(int localCity) {
		this.localCity = localCity;
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
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
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
	public Date getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}
	
	public String getRefuseReason() {
		return refuseReason;
	}
	public void setRefuseReason(String refuseReason) {
		this.refuseReason = refuseReason;
	}
	public String getResultDeal() {
		return resultDeal;
	}
	public void setResultDeal(String resultDeal) {
		this.resultDeal = resultDeal;
	}
	public String getCompanyRemark() {
		return companyRemark;
	}
	public void setCompanyRemark(String companyRemark) {
		this.companyRemark = companyRemark;
	}
	public double getReimbursementAmount() {
		return reimbursementAmount;
	}
	public void setReimbursementAmount(double reimbursementAmount) {
		this.reimbursementAmount = reimbursementAmount;
	}
	public int getBill() {
		return bill;
	}
	public void setBill(int bill) {
		this.bill = bill;
	}
	public Date getGetcardTime() {
		return getcardTime;
	}
	public void setGetcardTime(Date getcardTime) {
		this.getcardTime = getcardTime;
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
	public Date getInsurerTime() {
		return insurerTime;
	}
	public void setInsurerTime(Date insurerTime) {
		this.insurerTime = insurerTime;
	}
	public String getNotinsurerReason() {
		return notinsurerReason;
	}
	public void setNotinsurerReason(String notinsurerReason) {
		this.notinsurerReason = notinsurerReason;
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
	public String getHosState() {
		return hosState;
	}
	public void setHosState(String hosState) {
		this.hosState = hosState;
	}
		
}
