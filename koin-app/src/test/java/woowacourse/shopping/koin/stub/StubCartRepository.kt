package woowacourse.shopping.koin.stub

import woowacourse.shopping.koin.data.CartRepository
import woowacourse.shopping.koin.model.Product

class StubCartRepository: CartRepository {
                override suspend fun addCartProduct(product: Product) {
                    println("addCartProduct")
                }

                override suspend fun allCartProducts(): List<Product> {
                    return emptyList()
                }

                override suspend fun deleteCartProduct(id: Long) {
                    println("deleteCartProduct")
                }
            }