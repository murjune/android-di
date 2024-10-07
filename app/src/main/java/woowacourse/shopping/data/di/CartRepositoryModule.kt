package woowacourse.shopping.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import woowacourse.shopping.data.CartRepository
import woowacourse.shopping.data.DefaultCartRepository

@InstallIn(SingletonComponent::class)
@Module
abstract class CartRepositoryModule {
    @Binds
    abstract fun bindCartRepository(repository: DefaultCartRepository): CartRepository
}
