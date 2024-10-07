package woowacourse.shopping.data.di

import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.scopedOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import woowacourse.shopping.data.CartProductDao
import woowacourse.shopping.data.CartRepository
import woowacourse.shopping.data.DefaultCartRepository
import woowacourse.shopping.data.DefaultProductRepository
import woowacourse.shopping.data.InMemoryCartRepository
import woowacourse.shopping.data.ProductRepository
import woowacourse.shopping.data.ShoppingDatabase
import woowacourse.shopping.ui.MainViewModel
import woowacourse.shopping.ui.cart.CartActivity
import woowacourse.shopping.ui.cart.CartViewModel
import woowacourse.shopping.ui.cart.DateFormatter

val databaseModule =
    module {
        single<ShoppingDatabase> { ShoppingDatabase.instance(get()) }
        single<CartProductDao> { get<ShoppingDatabase>().cartProductDao() }
    }

val repositoryModule = module {
    single { ShoppingDatabase.instance(androidContext()).cartProductDao() }

    single<CartRepository> { DefaultCartRepository(get()) }
    single<CartRepository> { InMemoryCartRepository() }
    single<ProductRepository> { DefaultProductRepository() }

    viewModel { CartViewModel(get()) }
    viewModel { MainViewModel(get(), get()) }
}

val dateFormatterModule = module {
    scope<CartActivity> { scopedOf(::DateFormatter) }
}
