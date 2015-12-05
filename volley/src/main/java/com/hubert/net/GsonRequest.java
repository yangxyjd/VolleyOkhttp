package com.hubert.net;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import java.io.UnsupportedEncodingException;

/**
 * Created by yang on 2015/11/29 0029.
 */
public class GsonRequest <T> extends Request<T> {
    private  final Response.Listener<T>listener;
    private Gson gson;
    private Class<T> mClass;//泛型支持 需要进行GSON解析的类

    /**
     *
     * @param method 网络请求方法 GET POST
     * @param url 网络请求地址
     * @param listener 成功回调
     * @param errorListener 失败回调
     * @param pclass 需要进行GSON解析的类
     */
    public GsonRequest(int method, String url, Response.Listener<T> listener, Response.ErrorListener errorListener, Class pclass) {
        super(method, url, errorListener);
        gson = new Gson();
        this.listener = listener;
        mClass=pclass;
    }

    /**
     * 数据解析
     * @param response
     * @return
     */
    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            T data = gson.fromJson(json,mClass);
            return Response.success(data,HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }

    /**
     * 数据分发
     * @param response
     */
    @Override
    protected void deliverResponse(T response) {
        listener.onResponse(response);
    }
}
