package com.ina.android.tutortoyoumaster;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class EnrollClass implements Serializable {

    @SerializedName("idunclass")
    public int idunclass;

    @SerializedName("name")
    public String name;

    @SerializedName("description")
    public String description;

    @SerializedName("idtutor")
    public int idtutor;

    @SerializedName("region")
    public String region;

    @SerializedName("phone")
    public String phone;

}
