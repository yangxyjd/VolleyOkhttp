package com.hubert.net.listener;

import com.android.volley.VolleyError;

/**
 * Created by yang on 2015/12/1 0001.
 */
public interface RequestListener<T> {

    void onSuccessResponse(T response);

    void onErrorResponse(VolleyError error);
}
