package woowacourse.shopping.koin

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import woowacourse.shopping.koin.di.appModule

class ShoppingApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ShoppingApp)
            androidLogger(level = Level.DEBUG)
            modules(appModule)
        }
    }
}

