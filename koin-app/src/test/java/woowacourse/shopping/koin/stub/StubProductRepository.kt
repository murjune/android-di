package woowacourse.shopping.koin.stub

import woowacourse.shopping.koin.data.ProductRepository
import woowacourse.shopping.koin.model.Product

class StubProductRepository : ProductRepository {
                override suspend fun allProducts(): List<Product> {
                    return emptyList()
                }
            }