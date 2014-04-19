package jxau.sms.lyx.exception;

public class DataExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataExistException(String str){
		super(str);
	}
}
