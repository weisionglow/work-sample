package com.example.myapplication.model


import com.google.gson.annotations.SerializedName

data class ProfileResponse(
    @SerializedName("email")
    var email: String,
    @SerializedName("first_time_login")
    var firstTimeLogin: String,
    @SerializedName("id")
    var id: String,
    @SerializedName("id_no")
    var idNo: String,
    @SerializedName("intercom_id")
    var intercomId: String,
    @SerializedName("is_change")
    var isChange: Int,
    @SerializedName("is_nric")
    var isNric: Int,
    @SerializedName("is_tenant")
    var isTenant: Int,
    @SerializedName("is_tpc")
    var isTpc: Int,
    @SerializedName("is_tr_residence")
    var isTrResidence: Int,
    @SerializedName("is_tr_tenant")
    var isTrTenant: Int,
    @SerializedName("is_unit_added")
    var isUnitAdded: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("phone")
    var phone: String,
    @SerializedName("tpc_category")
    var tpcCategory: String,
    @SerializedName("tpc_image")
    var tpcImage: String,
    @SerializedName("unit_count")
    var unitCount: String,
    @SerializedName("unit_id")
    var unitId: String,

    @SerializedName("loyalty_no")
    var loyaltyNo: String,
    @SerializedName("loyalty_point_level")
    var loyaltyPointLevel: String,
    @SerializedName("loyalty_point_level_image")
    var loyaltyPointLevelImage: String,
    @SerializedName("loyalty_accumulate_points")
    var loyaltyAccumulatePoints: String,
    @SerializedName("loyalty_next_level_points")
    var loyaltyNextLevelPoints: String,
    @SerializedName("loyalty_balance_points")
    var loyaltyBalancePoints: String,
) {

    fun getPropertyCount(): String {
        return "$unitCount Property(ies)"
    }
}