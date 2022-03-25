package com.dakuinternational.common.domain.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Parcelize
@Keep
data class DataContent(
    var id: String? = "",
    var title: String? = "",
    var description: String? = "",
    var asset: String? = ""
) : Parcelable
