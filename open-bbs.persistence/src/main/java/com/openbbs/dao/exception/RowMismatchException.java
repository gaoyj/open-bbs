package com.openbbs.dao.exception;

public class RowMismatchException extends Exception {

	public RowMismatchException(){
		super();
	}
	
	public RowMismatchException(String msg) {
		super(msg);
	}
	
	public RowMismatchException(Throwable cause) {
		super(cause);
	}
	
	public RowMismatchException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
