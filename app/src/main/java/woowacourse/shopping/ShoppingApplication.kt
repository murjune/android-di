package woowacourse.shopping

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

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
