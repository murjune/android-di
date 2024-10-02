package woowacourse.shopping.koin.di

import org.koin.dsl.module

val appModule = module {
    includes(daoModule, repositoryModule, viewModelModule, utilityModule)
}