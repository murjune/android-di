package woowacourse.shopping

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import woowacourse.shopping.data.di.RepositoryModule

@HiltAndroidApp
class ShoppingApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        RepositoryModule(this).install()
    }
}
