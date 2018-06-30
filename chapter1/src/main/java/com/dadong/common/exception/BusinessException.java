package com.dadong.common.exception;

/**
 * Created by dadong on 2018/6/30.
 * 业务异常，方便直接返回给响应端
 */
public class BusinessException extends RuntimeException{
	/**
	 * 错误码。由于考虑到后期可能用标识型的错误码，比如error.no_login这样可读的，设置成String
	 */
	private String errorCode ;

	public BusinessException(String errorCode, String message){
		super(message);
		this.errorCode = errorCode ;
	}

	public BusinessException(String message){
		super(message);
	}

	public String getErrorCode() {
		return errorCode;
	}
}
