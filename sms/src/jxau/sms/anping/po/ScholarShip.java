package jxau.sms.anping.po;

import jxau.sms.chenjiang.po.StuBasicInfo;


/**
 * 班级奖学金实体表
 * @author anping
 * 2014-4-12
 * TODO
 */
public class ScholarShip {
	private StuBasicInfo student;// 学号
	private String term;// 学期
	private double baseScore;// 基准分
	private double awardScore;// 奖励分
	private double punishScore;// 惩罚分
	private double moralQualityAssessmentScore;// 德育素质测评总分
	private int moralQualityAssessmentRank;// 德育素质测评总分排名
	private double lessonScore;// 学业课程分
	private double innovateScore;// 科技活动与创新分
	private double skillsScore;// 职业技能分
	private double qualityScore;// 智育素质测评
	private int qualityRank;// 智育素质测评班级排名
	private double sportScore;// 体育课程（活动）分
	private double physiqueScore;// 体质健康测评分
	private double sportMatchScore;// 体育竞赛分
	private double sportQualityTotalScore;// 体育素质测评总分
	private int sportQualityRank;// 体育素质测评班级排名
	private double manageScore;// 管理艺术分
	private double cultureScore;// 文化艺术分
	private double mediaScore;// 媒体艺术分
	private double serviceScore;// 实践服务分
	private double artEducationTotalScore;// 美育素质测评总分
	private int artEducationTotalRank;// 美育素质测评班级排名
	private double totalScore;// 总分
	private int totalScoreRank;// 总分排名
	private String rank;// 奖学金等级
	private String remarks;// 审核失败原因备注
	private String exameState;//审核状态
	private String classGrantState;//禁用还是启用
	public StuBasicInfo getStudent() {
		return student;
	}
	public void setStudent(StuBasicInfo student) {
		this.student = student;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public double getBaseScore() {
		return baseScore;
	}
	public void setBaseScore(double baseScore) {
		this.baseScore = baseScore;
	}
	public double getAwardScore() {
		return awardScore;
	}
	public void setAwardScore(double awardScore) {
		this.awardScore = awardScore;
	}
	public double getPunishScore() {
		return punishScore;
	}
	public void setPunishScore(double punishScore) {
		this.punishScore = punishScore;
	}
	public double getMoralQualityAssessmentScore() {
		return moralQualityAssessmentScore;
	}
	public void setMoralQualityAssessmentScore(double moralQualityAssessmentScore) {
		this.moralQualityAssessmentScore = moralQualityAssessmentScore;
	}
	public int getMoralQualityAssessmentRank() {
		return moralQualityAssessmentRank;
	}
	public void setMoralQualityAssessmentRank(int moralQualityAssessmentRank) {
		this.moralQualityAssessmentRank = moralQualityAssessmentRank;
	}
	public double getLessonScore() {
		return lessonScore;
	}
	public void setLessonScore(double lessonScore) {
		this.lessonScore = lessonScore;
	}
	public double getInnovateScore() {
		return innovateScore;
	}
	public void setInnovateScore(double innovateScore) {
		this.innovateScore = innovateScore;
	}
	public double getSkillsScore() {
		return skillsScore;
	}
	public void setSkillsScore(double skillsScore) {
		this.skillsScore = skillsScore;
	}
	public double getQualityScore() {
		return qualityScore;
	}
	public void setQualityScore(double qualityScore) {
		this.qualityScore = qualityScore;
	}
	public int getQualityRank() {
		return qualityRank;
	}
	public void setQualityRank(int qualityRank) {
		this.qualityRank = qualityRank;
	}
	public double getSportScore() {
		return sportScore;
	}
	public void setSportScore(double sportScore) {
		this.sportScore = sportScore;
	}
	public double getPhysiqueScore() {
		return physiqueScore;
	}
	public void setPhysiqueScore(double physiqueScore) {
		this.physiqueScore = physiqueScore;
	}
	public double getSportMatchScore() {
		return sportMatchScore;
	}
	public void setSportMatchScore(double sportMatchScore) {
		this.sportMatchScore = sportMatchScore;
	}
	public double getSportQualityTotalScore() {
		return sportQualityTotalScore;
	}
	public void setSportQualityTotalScore(double sportQualityTotalScore) {
		this.sportQualityTotalScore = sportQualityTotalScore;
	}
	public int getSportQualityRank() {
		return sportQualityRank;
	}
	public void setSportQualityRank(int sportQualityRank) {
		this.sportQualityRank = sportQualityRank;
	}
	public double getManageScore() {
		return manageScore;
	}
	public void setManageScore(double manageScore) {
		this.manageScore = manageScore;
	}
	public double getCultureScore() {
		return cultureScore;
	}
	public void setCultureScore(double cultureScore) {
		this.cultureScore = cultureScore;
	}
	public double getMediaScore() {
		return mediaScore;
	}
	public void setMediaScore(double mediaScore) {
		this.mediaScore = mediaScore;
	}
	public double getServiceScore() {
		return serviceScore;
	}
	public void setServiceScore(double serviceScore) {
		this.serviceScore = serviceScore;
	}
	public double getArtEducationTotalScore() {
		return artEducationTotalScore;
	}
	public void setArtEducationTotalScore(double artEducationTotalScore) {
		this.artEducationTotalScore = artEducationTotalScore;
	}
	public int getArtEducationTotalRank() {
		return artEducationTotalRank;
	}
	public void setArtEducationTotalRank(int artEducationTotalRank) {
		this.artEducationTotalRank = artEducationTotalRank;
	}
	public double getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}
	public int getTotalScoreRank() {
		return totalScoreRank;
	}
	public void setTotalScoreRank(int totalScoreRank) {
		this.totalScoreRank = totalScoreRank;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getExameState() {
		return exameState;
	}
	public void setExameState(String exameState) {
		this.exameState = exameState;
	}
	public String getClassGrantState() {
		return classGrantState;
	}
	public void setClassGrantState(String classGrantState) {
		this.classGrantState = classGrantState;
	}

	
}
