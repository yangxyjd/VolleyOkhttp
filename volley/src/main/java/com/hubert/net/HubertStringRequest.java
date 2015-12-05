package com.hubert.net;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.hubert.net.listener.RequestListener;

import java.util.Map;

/**
 * Created by yang on 2015/12/1 0001.
 */
public class HubertStringRequest extends BaseRequest {
    protected HubertStringRequest(Context context) {
        super(context);
    }

    /**
     * 普通文本 无参
     * @param url
     * @param listener
     */
    public void get(String url, final RequestListener<String> listener) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET,url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                if (listener != null) {
                    listener.onSuccessResponse(response);
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if (listener != null) {
                    listener.onErrorResponse(error);
                }
            }
        });
        addRequest(stringRequest);
    }

    /**
     * 普通文本,携带参数
     * @param url
     * @param params
     * @param listener
     */
    public void get(String url,Map<String,String> params, final RequestListener<String> listener) {
        url = createGetUrlWithParams(url,params);//加入参数
        this.get(url, listener);
    }

    /**
     * 普通文本 POST
     * @param url
     *  @param params 参数
     * @param listener
     */
    public void post(String url, Map<String,String> params,final RequestListener<String> listener) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                if (listener != null) {
                    listener.onSuccessResponse(response);
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if (listener != null) {
                    listener.onErrorResponse(error);
                }
            }
        });
        addRequest(stringRequest,params);
    }
}
