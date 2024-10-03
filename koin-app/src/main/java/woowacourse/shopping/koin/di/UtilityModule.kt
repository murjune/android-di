package woowacourse.shopping.koin.di

import android.content.Context
import org.koin.dsl.module
import woowacourse.shopping.koin.ui.cart.DateFormatter

val utilityModule = module {
    factory { (activityContext: Context) -> DateFormatter(activityContext) }
}
