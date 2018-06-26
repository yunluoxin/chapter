package com.dadong.common.vo;

import java.io.Serializable;

/**
 * Created by dadong on 2018/6/26.
 * Api访问时候网络响应的对象
 */
public class ApiResponse implements Serializable{

	private boolean success = true ;

	private Integer errorCode ;

	private Object data ;

	private String errorMsg ;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
