package woowacourse.shopping.koin.di

import androidx.room.Room
import org.koin.dsl.module
import woowacourse.shopping.koin.data.CartProductDao
import woowacourse.shopping.koin.data.ShoppingDatabase

val daoModule = module {
    single<ShoppingDatabase> {
        Room.databaseBuilder(
            get(),
            ShoppingDatabase::class.java,
            ShoppingDatabase.NAME
        ).build()
    }

    single<CartProductDao> { get<ShoppingDatabase>().cartProductDao() }
}