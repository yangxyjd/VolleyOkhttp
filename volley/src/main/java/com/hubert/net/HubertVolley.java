package com.hubert.net;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by yang on 2015/11/29 0029.
 */
public class HubertVolley {

    private static RequestQueue instance;

    public static RequestQueue getInstace(Context pContext) {
        if (instance == null) {
            instance = Volley.newRequestQueue(pContext,new OkHttpStack());
        }
        return instance;
    }
    public static void cancelRequest(String tag){
        instance.cancelAll(tag);
    }

}
