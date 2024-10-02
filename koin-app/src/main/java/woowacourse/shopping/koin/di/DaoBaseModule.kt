package woowacourse.shopping.koin.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import woowacourse.shopping.koin.data.CartProductDao
import woowacourse.shopping.koin.data.ShoppingDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoBaseModule {

    @Provides
    @Singleton
    fun provideCartProductDao(database: ShoppingDatabase): CartProductDao =
        database.cartProductDao()
}
