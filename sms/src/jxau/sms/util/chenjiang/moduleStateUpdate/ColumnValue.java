package jxau.sms.util.chenjiang.moduleStateUpdate;

public class ColumnValue<T> {
	private String column;
	private Object value;
	
	public String toString() {
		return column+","+value;
	}
	
	public ColumnValue() {
		
	}
	
	public ColumnValue(String column,Object value) {
		this.column = column;
		this.value = value;
	}
	
	public String getColumn() {
		return column;
	}
	public Object getValue() {
		return value;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public void setValue(Object value) {
		this.value = value;
	}
}
