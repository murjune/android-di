package woowacourse.shopping.koin.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import woowacourse.shopping.koin.ui.MainViewModel
import woowacourse.shopping.koin.ui.cart.CartViewModel

val viewModelModule = module {
    // viewModel
    viewModel { MainViewModel(get(), get()) }
    viewModel { CartViewModel(get()) }
}