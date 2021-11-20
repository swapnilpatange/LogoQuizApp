package app.phone.machinecoding.di

import app.phone.machinecoding.provider.imageloader.ImageLoader
import app.phone.machinecoding.provider.imageloader.ImageLoaderImpl
import app.phone.machinecoding.provider.resourceprovider.ResourceProvider
import app.phone.machinecoding.provider.resourceprovider.ResourceProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AppBindsModule {

    @Binds
    @Singleton
    fun bindsResourceProvider(resourceProviderImpl: ResourceProviderImpl): ResourceProvider

    @Binds
    @Singleton
    fun bindsImageLoader(imageLoaderImpl: ImageLoaderImpl): ImageLoader
}