package app.phone.machinecoding.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LogoQuizModel(
    @SerializedName("imgUrl") val imgUrl: String? = null,
    @SerializedName("name") val name: String? = null
) : Parcelable