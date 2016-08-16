package com.openbbs.exception;

/**
 * 异常类
 * 
 * @author gaoyj
 * @date 2016
 *
 */
public class BBSException extends RuntimeException {

	private static final long serialVersionUID = 312425611935799776L;

	private String code;

	private String message;

	private Throwable throwable;

	public BBSException(String code, String message, Throwable throwable) {
		super();
		this.code = code;
		this.message = message;
		this.throwable = throwable;
	}

	public BBSException(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}

}
