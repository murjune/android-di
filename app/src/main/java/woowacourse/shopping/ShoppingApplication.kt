package woowacourse.shopping

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import woowacourse.shopping.data.CartProductDao
import woowacourse.shopping.data.CartRepository
import woowacourse.shopping.data.DataBaseCartRepository
import woowacourse.shopping.data.InMemoryCartRepository
import woowacourse.shopping.data.ProductRepository
import woowacourse.shopping.data.ProductRepositoryImpl
import woowacourse.shopping.data.ShoppingDatabase
import woowacourse.shopping.ui.MainViewModel
import woowacourse.shopping.ui.cart.CartActivity
import woowacourse.shopping.ui.cart.CartViewModel
import woowacourse.shopping.ui.cart.DateFormatter

class ShoppingApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ShoppingApplication)
            androidLogger()
            modules(databaseModule, repositoryModule, viewModelModule, dateFormatterModule)
        }
    }
}

val databaseModule =
    module {
        single<ShoppingDatabase> {
            ShoppingDatabase.getInstance(get())
        }
        single<CartProductDao> { get<ShoppingDatabase>().cartProductDao() }
    }

val repositoryModule =
    module {
        single<CartRepository>(named("Database")) { DataBaseCartRepository(get()) }
        single<CartRepository>(named("InMemory")) { InMemoryCartRepository() }
        factory<ProductRepository> { ProductRepositoryImpl() }
    }

val viewModelModule =
    module {
        viewModel {
            MainViewModel(get(), get(qualifier = named("Database")))
        }

        viewModel {
            CartViewModel(get(qualifier = named("Database")))
        }
    }

val dateFormatterModule =
    module {
        scope<CartActivity> {
            scoped { DateFormatter(get()) }
        }
    }
