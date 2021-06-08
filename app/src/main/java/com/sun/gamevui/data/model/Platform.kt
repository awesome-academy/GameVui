package com.sun.gamevui.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Platform(
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String
) : Parcelable
