package woowacourse.shopping.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import woowacourse.shopping.data.ProductRepository
import woowacourse.shopping.data.ProductRepositoryImpl

@InstallIn(ViewModelComponent::class)
@Module
abstract class ProductRepositoryModule {
    @Binds
    abstract fun provideProductRepositoryImpl(productRepositoryImpl: ProductRepositoryImpl): ProductRepository
}
