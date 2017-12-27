package com.fueledbyarif.android.uniten_v110;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 28/8/2016.
 */
public class LoginRequest extends StringRequest{

    private static final String LOGIN_REQUEST_URL = "http://10.0.2.2/unitendb/Login.php";
    private Map<String, String> params;

    public LoginRequest (String studentId, String studentpassword, Response.Listener<String> listener){
        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("studentId", studentId);
        params.put("studentpassword", studentpassword);
    }

    @Override
    public Map<String, String> getParams(){
        return params;
    }

}
