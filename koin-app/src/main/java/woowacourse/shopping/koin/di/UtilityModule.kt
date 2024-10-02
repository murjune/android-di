package woowacourse.shopping.koin.di

import org.koin.dsl.module
import woowacourse.shopping.koin.ui.cart.DateFormatter

val utilityModule = module {
    single { DateFormatter(get()) }
}
