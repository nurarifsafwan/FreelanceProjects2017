package com.fueledbyarif.android.chilis_v104;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by user on 24/8/2016.
 */
public class Menu implements Serializable{

    @SerializedName("menu_id")
    public int menu_id;

    @SerializedName("name")
    public String name;

    @SerializedName("price")
    public float price;

    @SerializedName("description")
    public String description;

    @SerializedName("image_url")
    public String image_url;

}
