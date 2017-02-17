package org.talend.marketo.type;

import java.util.Map;

public class MarketoError {

	private String code;

	private String message;

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
	
	@Override
	public String toString() {
		return "MarketoError [code=" + code + ", message=" + message + "]";
	}
	
}
