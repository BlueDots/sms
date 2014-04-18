package jxau.sms.qing.exception;

public class LoginException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public final static String nameOrPsdError = "用户名或密码错误！";
	public final static String stateDatedError = "用户过了使用期！";
	public LoginException(String message){
		super(message);
	}
}
