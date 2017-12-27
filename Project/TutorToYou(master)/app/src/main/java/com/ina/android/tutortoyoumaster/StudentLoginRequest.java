package com.ina.android.tutortoyoumaster;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class StudentLoginRequest extends StringRequest {

    private static final String LOGIN_STUDENT_URL = "http://10.0.2.2/tutortoyou/Login.php";
    private Map<String, String> params;

    public StudentLoginRequest(String username, String password, Response.Listener<String> listener){
        super(Request.Method.POST, LOGIN_STUDENT_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

}
