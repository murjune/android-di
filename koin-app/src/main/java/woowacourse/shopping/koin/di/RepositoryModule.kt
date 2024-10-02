package woowacourse.shopping.koin.di

import org.koin.dsl.module
import woowacourse.shopping.koin.data.CartRepository
import woowacourse.shopping.koin.data.DefaultCartRepository
import woowacourse.shopping.koin.data.ProductRepository
import woowacourse.shopping.koin.data.ProductRepositoryImpl


val repositoryModule = module {
    single<ProductRepository> { ProductRepositoryImpl() }
    single<CartRepository> { DefaultCartRepository(get()) }
}