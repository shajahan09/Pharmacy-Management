package com.test.pharmecyproject.model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("name")
    String name;
    @SerializedName("email")
    String email;
    @SerializedName("password")
    String password;
    @SerializedName("gender")
    String gender;
    @SerializedName("phone")
    String phone;
    @SerializedName("id")
    int id;
}
