package woowacourse.shopping.koin.di

import org.koin.core.module.dsl.scopedOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import woowacourse.shopping.koin.data.CartRepository
import woowacourse.shopping.koin.data.DefaultCartRepository
import woowacourse.shopping.koin.ui.MainViewModel
import woowacourse.shopping.koin.ui.cart.CartViewModel

val viewModelModule = module {
    viewModelOf(::MainViewModel)
    viewModelOf(::CartViewModel)
    scope<CartViewModel> {
        scopedOf(::DefaultCartRepository).bind<CartRepository>()
    }
}