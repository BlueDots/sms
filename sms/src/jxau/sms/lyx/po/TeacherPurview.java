package jxau.sms.lyx.po;

/**
 * 
 * @author Administrator
 * 2014-4-12
 * TODO：
 * 		中间表，教师权限表
 */
public class TeacherPurview {

		private String teacherNo;				//教师编号
		private int purviewNo;					//权限编号
		
		public String getTeacherNo() {
			return teacherNo;
		}
		public void setTeacherNo(String teacherNo) {
			this.teacherNo = teacherNo;
		}
		public int getPurviewNo() {
			return purviewNo;
		}
		public void setPurviewNo(int purviewNo) {
			this.purviewNo = purviewNo;
		}

}
