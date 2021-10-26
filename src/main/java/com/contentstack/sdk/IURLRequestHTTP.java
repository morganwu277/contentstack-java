package com.contentstack.sdk;

import org.json.JSONObject;

import java.util.LinkedHashMap;

public interface IURLRequestHTTP {

    public void send();

    public LinkedHashMap<String, String> getHeaders();

    public void setHeaders(LinkedHashMap<String, Object> headers);

    public JSONObject getResponse();

    public String getInfo();

    public void setInfo(String info);

    public String getController();

    public void setController(String controller);

    public ResultCallBack getCallBackObject();

    public void setCallBackObject(ResultCallBack builtResultCallBackObject);

}
