package woowacourse.shopping.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import woowacourse.shopping.data.DefaultProductRepository
import woowacourse.shopping.data.ProductRepository


@InstallIn(ViewModelComponent::class)
@Module
abstract class ProductRepositoryModule {
    @Binds
    abstract fun bindProductRepository(repository: DefaultProductRepository): ProductRepository
}
