package com.hubert.net;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by yang on 2015/12/1 0001.
 */
public class BaseRequest {
    private Context mContext;
    protected static RequestQueue requestQueue;

    protected BaseRequest(Context context) {
        mContext = context;
    }

    protected void addRequest(Request request, Map<String, String> params) {
        request.setParams(params);
        HubertVolley.getInstace(mContext).add(request);
    }

    protected void addRequest(Request request) {
        HubertVolley.getInstace(mContext).add(request);
    }

    /**
     * 创建一个带参数的GET请求URL
     * @param url
     * @param params
     * @return
     */
    protected String createGetUrlWithParams(String url, Map<String, String> params) {
        if (params != null) {
            StringBuffer stringBuffer = new StringBuffer(url);
            if (!url.contains("?")) {
                stringBuffer.append('?');
            }
            for (Map.Entry<String, String> entry : params.entrySet()) {
                String key = entry.getKey().toString();
                String value = null;
                if (entry.getValue() == null) {
                    value = "";
                } else {
                    value = entry.getValue().toString();
                }
                stringBuffer.append(key);
                stringBuffer.append("=");
                try {
                    value = URLEncoder.encode(value, "UTF-8");
                    stringBuffer.append(value);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                stringBuffer.append('&');
            }
            //删除最后一个'&'
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            url = stringBuffer.toString();
        }
        return url;
    }
}
