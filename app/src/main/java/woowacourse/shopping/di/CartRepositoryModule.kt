package woowacourse.shopping.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import woowacourse.shopping.data.CartRepository
import woowacourse.shopping.data.DataBaseCartRepository
import woowacourse.shopping.data.InMemoryCartRepository
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class CartRepositoryModule {
    @Binds
    @Database
    @Singleton
    abstract fun bindDatabaseCartRepository(dataBaseCartRepository: DataBaseCartRepository): CartRepository

    @Binds
    @InMemory
    @Singleton
    abstract fun bindInMemoryCartRepository(inMemoryCartRepository: InMemoryCartRepository): CartRepository
}
