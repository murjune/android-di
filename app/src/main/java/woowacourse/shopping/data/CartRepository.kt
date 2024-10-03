package woowacourse.shopping.data

import woowacourse.shopping.data.mapper.toDomain
import woowacourse.shopping.data.mapper.toEntity
import woowacourse.shopping.model.CartProduct
import woowacourse.shopping.model.Product
import woowacourse.shopping.model.toCart

interface CartRepository {
    suspend fun addCartProduct(product: Product)

    suspend fun getAllCartProducts(): List<CartProduct>

    suspend fun deleteCartProduct(id: Long)
}

class DataBaseCartRepository(
    private val cartProductDao: CartProductDao,
) : CartRepository {
    override suspend fun addCartProduct(product: Product) = cartProductDao.insert(product.toEntity())

    override suspend fun getAllCartProducts(): List<CartProduct> = cartProductDao.getAll().map { it.toDomain() }

    override suspend fun deleteCartProduct(id: Long) = cartProductDao.delete(id)
}

class InMemoryCartRepository : CartRepository {
    private val cartProducts: MutableList<CartProduct> = mutableListOf()

    override suspend fun addCartProduct(product: Product) {
        cartProducts.add(product.toCart(cartProducts.size.toLong()))
    }

    override suspend fun getAllCartProducts(): List<CartProduct> = cartProducts

    override suspend fun deleteCartProduct(id: Long) {
        cartProducts.removeIf { it.id == id }
    }
}
