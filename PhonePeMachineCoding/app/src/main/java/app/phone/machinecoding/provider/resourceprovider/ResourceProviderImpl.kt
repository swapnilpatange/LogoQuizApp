package app.phone.machinecoding.provider.resourceprovider

import android.content.Context
import androidx.annotation.RawRes
import app.phone.machinecoding.model.LogoQuizModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ResourceProviderImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val gson: Gson
) : ResourceProvider {

    override fun readRawJson(@RawRes rawResId: Int): List<LogoQuizModel> {
        context.resources.openRawResource(rawResId).bufferedReader().use {
            return gson.fromJson(it, object : TypeToken<List<LogoQuizModel>>() {}.type)
        }
    }
}