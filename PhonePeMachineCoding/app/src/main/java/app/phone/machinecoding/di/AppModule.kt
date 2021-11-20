package app.phone.machinecoding.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [AppBindsModule::class])
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesGson():Gson {
        return GsonBuilder().create()
    }
}