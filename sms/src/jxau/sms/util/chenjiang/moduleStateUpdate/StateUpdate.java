package jxau.sms.util.chenjiang.moduleStateUpdate;

import java.util.List;
//处理审核，删除的类
public class StateUpdate {
	private String id;//id

	private List<String> relatedStates;//状态字段相关联字段

	private String remarks;//备注字段

	private String state;//状态字段

	private String table;//表名

	public String toString() {
		StringBuffer relatedStateString = new StringBuffer();
		if(relatedStates != null) {
			for(int i=0;i<relatedStates.size();i++){
				relatedStateString.append(relatedStates.get(i)+" , ");
			}		
		}
		return "table:"+table+"\nid:"+id
				+"\nstate:"+state+"-----relatedStates:"+relatedStateString
				+"\nremarks:"+remarks;
	}
	
	public String getId() {
		return id;
	}

	public List<String> getRelatedStates() {
		return relatedStates;
	}

	public String getRemarks() {
		return remarks;
	}

	public String getState() {
		return state;
	}

	public String getTable() {
		return table;
	}

	public void setId(String id) {
		this.id = id;
	}
	public void setRelatedStates(List<String> relatedStates) {
		this.relatedStates = relatedStates;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setTable(String table) {
		this.table = table;
	}

	
	
	

}
