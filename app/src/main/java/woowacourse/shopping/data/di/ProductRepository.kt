package woowacourse.shopping.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import woowacourse.shopping.data.DefaultProductRepository


@InstallIn(ViewModelComponent::class)
@Module
abstract class ProductRepository {
    @Binds
    abstract fun bindProductRepository(repository: DefaultProductRepository): ProductRepository
}
