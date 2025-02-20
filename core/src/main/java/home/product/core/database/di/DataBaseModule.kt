package home.product.core.database.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import home.product.core.database.DataBase
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideDataBase(context: Context): DataBase {
        return Room.databaseBuilder(context, DataBase::class.java, DataBase.DB_NAME).build()
    }

    @Singleton
    @Provides
    fun provideMainDao(db: DataBase) = db.getFavoriteDao()
}