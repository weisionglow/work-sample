package com.example.myapplication.model

import com.google.gson.annotations.SerializedName

class LoginRequest {

    @SerializedName("username")
    var username: String = ""

    @SerializedName("password")
    var password: String = ""

    @SerializedName("client_id")
    var clientId: String = "2"

    @SerializedName("client_secret")
    var clientSecret: String = "nQzkjIGF6rE6mATjRDFNyBBxnD5Bc3EOstxmhTUc"

    @SerializedName("grant_type")
    var grantType: String = "password"
}