package woowacourse.shopping.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import woowacourse.shopping.data.CartProductDao
import woowacourse.shopping.data.ShoppingDatabase
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Provides
    @Singleton
    fun provideCartProductDao(database: ShoppingDatabase): CartProductDao {
        return database.cartProductDao()
    }

    @Provides
    @Singleton
    fun provideShoppingDatabase(
        @ApplicationContext context: Context,
    ): ShoppingDatabase {
        return ShoppingDatabase.getInstance(context)
    }
}
