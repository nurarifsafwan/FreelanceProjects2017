package com.anis.android.confinementladymaster;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LadyInsertRequest extends StringRequest{

    private static final String INSERT_LADY_URL = "http://10.0.2.2/confinement/insertclass.php";
    private Map<String, String> params;

    public LadyInsertRequest(String name, String description, int idlady, String region, String phone, Response.Listener<String> listener){
        super(Request.Method.POST, INSERT_LADY_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("description", description);
        params.put("idlady", idlady + "");
        params.put("region", region);
        params.put("phone", phone);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

}
