package woowacourse.shopping

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import woowacourse.shopping.data.di.databaseModule
import woowacourse.shopping.data.di.dateFormatterModule
import woowacourse.shopping.data.di.repositoryModule

class ShoppingApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ShoppingApplication)
            androidLogger(Level.DEBUG)
            modules(
                databaseModule,
                repositoryModule,
                dateFormatterModule,
            )
        }
    }
}
