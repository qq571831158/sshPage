package com.ch.bean;

/**
 * Created by apple on 2017/5/17.
 */
public class OBeanBase {
    private String code;
    private String message;
    private Object contents;

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

    public Object getContents() {
        return contents;
    }

    public OBeanBase(){}

    public void setContents(Object contents) {
        this.contents = contents;
    }
    public void setInfo(String code,String message){
        this.code = code;
        this.message = message;
    }

    public OBeanBase(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public OBeanBase(String code, Object contents, String message) {
        this.code = code;
        this.contents = contents;
        this.message = message;
    }


}
