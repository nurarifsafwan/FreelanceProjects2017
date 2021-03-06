package com.ina.android.tutortoyoumaster;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class StudentInsertClass extends StringRequest{

    private static final String INSERT_STUDENT_URL = "http://10.0.2.2/tutortoyou/EnrollClass.php";
    private Map<String, String> params;

    public StudentInsertClass(String name, String description, String region, String phone, int idstudent, int idtutor, Response.Listener<String> listener){
        super(Request.Method.POST, INSERT_STUDENT_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("description", description);
        params.put("region", region);
        params.put("phone", phone);
        params.put("idstudent", idstudent + "");
        params.put("idtutor", idtutor + "");
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

}
