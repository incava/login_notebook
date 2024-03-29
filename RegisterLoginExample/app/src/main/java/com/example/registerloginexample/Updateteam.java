package com.example.registerloginexample;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Updateteam extends StringRequest {
    //서버 URL 설정 (php 파일 연동)
    final static private String URL = "http://ingi1118.ivyro.net/Updatetmeam.php";
    private Map<String, String> map;

    public Updateteam(String userID, Response.Listener<String> listener){
        super(Method.POST, URL , listener ,null);
        map = new HashMap<>();
        map.put("userID",userID);
    }

    @Nullable
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
