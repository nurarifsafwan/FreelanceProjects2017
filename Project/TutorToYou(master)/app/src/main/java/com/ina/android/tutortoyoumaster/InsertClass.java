package com.ina.android.tutortoyoumaster;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class InsertClass extends StringRequest{

    private static final String INSERT_CLASS_URL = "http://10.0.2.2/tutortoyou/InsertClass.php";
    private Map<String, String> params;

    public InsertClass(String name, String description, int idtutor, String region, String phone, Response.Listener<String> listener){
        super(Request.Method.POST, INSERT_CLASS_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("description", description);
        params.put("idtutor", idtutor + "");
        params.put("region", region);
        params.put("phone", phone);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

}
