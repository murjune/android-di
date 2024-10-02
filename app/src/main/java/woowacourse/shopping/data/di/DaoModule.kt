package woowacourse.shopping.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import woowacourse.shopping.data.CartProductDao
import woowacourse.shopping.data.ShoppingDatabase

@InstallIn(SingletonComponent::class)
@Module
object DaoModule {
    @Provides
    fun provideCartProductDao(database: ShoppingDatabase): CartProductDao {
        return database.cartProductDao()
    }
}
