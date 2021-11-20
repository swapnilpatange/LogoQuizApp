package app.phone.machinecoding.provider.resourceprovider

import androidx.annotation.RawRes

interface ResourceProvider {
    fun <T> readRawJson(@RawRes rawResId: Int): T
}