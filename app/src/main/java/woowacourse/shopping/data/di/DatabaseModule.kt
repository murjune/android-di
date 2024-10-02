package woowacourse.shopping.data.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import woowacourse.shopping.data.ShoppingDatabase

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    fun provideShoppingDatabase(@ApplicationContext context: Context): ShoppingDatabase {
        return ShoppingDatabase.instance(context)
    }
}
