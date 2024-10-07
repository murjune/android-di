package woowacourse.shopping.data

import woowacourse.shopping.data.mapper.toEntity
import woowacourse.shopping.model.Product
import javax.inject.Inject

class InMemoryCartRepository @Inject constructor() : CartRepository {
    private val cartProducts = mutableListOf<CartProductEntity>()

    override suspend fun addCartProduct(product: Product) {
        cartProducts.add(product.toEntity())
    }

    override suspend fun cartProducts(): List<CartProductEntity> = cartProducts

    override suspend fun deleteCartProduct(id: Long) {
        cartProducts.removeIf { it.id == id }
    }

    companion object {
        const val QUALIFIER_NAME = "InMemory"
    }
}
