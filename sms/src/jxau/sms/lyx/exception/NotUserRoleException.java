package jxau.sms.lyx.exception;

public class NotUserRoleException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotUserRoleException(String str){
		super(str);
	}
}
