package kr.or.ddit.login;

/**
 * 사용자 인증 실패를 표현할 예외
 *
 */
public class AuthenticateException extends RuntimeException{

	public AuthenticateException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthenticateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public AuthenticateException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AuthenticateException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AuthenticateException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
