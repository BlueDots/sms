package jxau.sms.util.chenjiang.roleVerify;


//处理审核的类,存储模块审核的相关信息
public class ModuleVerify {
	private String id;//id

	private String remarks;//备注字段

	private String table;//表名

	private String verify;//审核字段

	public String toString() {

		return "table:"+table+"\nid:"+id+"\nverify:"+verify
				+"\nremarks:"+remarks;
	}
	
	public String getId() {
		return id;
	}



	public String getRemarks() {
		return remarks;
	}




	public String getTable() {
		return table;
	}


	public String getVerify() {
		return verify;
	}


	public void setId(String id) {
		this.id = id;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setTable(String table) {
		this.table = table;
	}
	public void setVerify(String verify) {
		this.verify = verify;
	}
	
	

}
