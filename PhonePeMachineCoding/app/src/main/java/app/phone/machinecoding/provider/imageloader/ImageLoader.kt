package app.phone.machinecoding.provider.imageloader

import android.widget.ImageView

interface ImageLoader {

    fun loadImage(imageView: ImageView, imageUrl: String?)
}