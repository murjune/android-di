package woowacourse.shopping.koin.di

import android.content.Context
import org.koin.dsl.module
import woowacourse.shopping.koin.ui.cart.CartActivity
import woowacourse.shopping.koin.ui.cart.DateFormatter

val utilityModule = module {
    scope<CartActivity> {
        scoped { (activityContext: Context) -> DateFormatter(activityContext) }
    }
}
