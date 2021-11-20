package app.phone.machinecoding.provider.imageloader

import android.widget.ImageView
import com.bumptech.glide.Glide
import javax.inject.Inject

class ImageLoaderImpl @Inject constructor() : ImageLoader {
    override fun loadImage(imageView: ImageView, imageUrl: String?) {
        Glide.with(imageView).load(imageUrl).into(imageView)
    }
}