package com.anis.android.confinementladymaster;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class UserRegisterRequest extends StringRequest{

    private static final String REGISTER_USER_REQUEST_URL = "http://10.0.2.2/confinement/registeruser.php";
    private Map<String, String> params;

    public UserRegisterRequest(String username, String password, String name, String phone, String address, Response.Listener<String> listener){
        super(Method.POST, REGISTER_USER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        params.put("name", name);
        params.put("phone", phone);
        params.put("address", address);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

}
