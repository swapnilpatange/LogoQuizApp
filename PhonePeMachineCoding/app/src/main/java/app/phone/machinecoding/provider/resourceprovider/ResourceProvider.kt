package app.phone.machinecoding.provider.resourceprovider

import androidx.annotation.RawRes
import app.phone.machinecoding.model.LogoQuizModel

interface ResourceProvider {
    fun readRawJson(@RawRes rawResId: Int): List<LogoQuizModel>
}