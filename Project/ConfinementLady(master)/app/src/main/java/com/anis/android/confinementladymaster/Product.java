package com.anis.android.confinementladymaster;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Product implements Serializable{

    @SerializedName("idunpackage")
    public int idunpackege;

    @SerializedName("name")
    public String name;

    @SerializedName("description")
    public String description;

    @SerializedName("region")
    public String region;

    @SerializedName("idlady")
    public int idlady;

    @SerializedName("phone")
    public String phone;

}
