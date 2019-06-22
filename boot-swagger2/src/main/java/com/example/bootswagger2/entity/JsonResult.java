package com.example.bootswagger2.entity;

public class JsonResult {

	private String status = null;

	private Object result = null;

	// Getter Setter

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}