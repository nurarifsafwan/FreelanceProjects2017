package com.ina.android.tutortoyoumaster;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class StudentRegisterRequest extends StringRequest{

    private static final String REGISTER_STUDENT_URL = "http://10.0.2.2/tutortoyou/Register.php";
    private Map<String, String> params;

    public StudentRegisterRequest(String username, String password, String name, String email, String phone, Response.Listener<String> listener){
        super(Method.POST, REGISTER_STUDENT_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        params.put("name", name);
        params.put("email", email);
        params.put("phone", phone);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

}
