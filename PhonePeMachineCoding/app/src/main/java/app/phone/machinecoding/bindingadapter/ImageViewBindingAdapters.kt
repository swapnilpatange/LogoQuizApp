package app.phone.machinecoding.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import app.phone.machinecoding.provider.imageloader.ImageLoader

object ImageViewBindingAdapters {
    lateinit var imageLoader: ImageLoader

    @JvmStatic
    @BindingAdapter(value = ["imageUrl"])
    fun ImageView.loadImageUrl(
        imageUrl:String?
    ) {
        imageLoader.loadImage(
            imageUrl = imageUrl,
            imageView = this
        )
    }
}