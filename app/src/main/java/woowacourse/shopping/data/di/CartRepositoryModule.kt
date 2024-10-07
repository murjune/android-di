package woowacourse.shopping.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import woowacourse.shopping.data.CartRepository
import woowacourse.shopping.data.DefaultCartRepository
import javax.inject.Singleton

@InstallIn(Singleton::class)
@Module
abstract class CartRepositoryModule {
    @Binds
    abstract fun bindCartRepository(repository: DefaultCartRepository): CartRepository
}
