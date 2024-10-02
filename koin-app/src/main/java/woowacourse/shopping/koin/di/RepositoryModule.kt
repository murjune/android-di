package woowacourse.shopping.koin.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import woowacourse.shopping.koin.data.CartRepository
import woowacourse.shopping.koin.data.DefaultCartRepository
import woowacourse.shopping.koin.data.ProductRepository
import woowacourse.shopping.koin.data.ProductRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindProductRepository(repository: ProductRepositoryImpl): ProductRepository

    @Binds
    @Singleton
    abstract fun bindCartRepository(repository: DefaultCartRepository): CartRepository
}
