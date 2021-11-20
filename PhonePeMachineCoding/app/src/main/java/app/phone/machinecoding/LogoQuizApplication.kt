package app.phone.machinecoding

import android.app.Application
import app.phone.machinecoding.bindingadapter.ImageViewBindingAdapters
import app.phone.machinecoding.provider.imageloader.ImageLoaderImpl
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class LogoQuizApplication:Application() {

    @Inject
    lateinit var imageloader:ImageLoaderImpl

    override fun onCreate() {
        super.onCreate()
        ImageViewBindingAdapters.imageLoader = imageloader
    }
}