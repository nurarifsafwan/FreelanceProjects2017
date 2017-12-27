package com.anis.android.confinementladymaster;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class UserInsertRequest extends StringRequest{

    private static final String INSERT_USER_URL = "http://10.0.2.2/confinement/insertuserpackage.php";
    private Map<String, String> params;

    public UserInsertRequest(String name, String description, String region, int idlady, int iduser, String phone, Response.Listener<String> listener){
        super(Request.Method.POST, INSERT_USER_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("description", description);
        params.put("region", region);
        params.put("idlady", idlady + "");
        params.put("iduser", iduser + "");
        params.put("phone", phone);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

}
