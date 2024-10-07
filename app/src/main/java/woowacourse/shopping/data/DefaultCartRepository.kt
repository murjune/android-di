package woowacourse.shopping.data

import woowacourse.shopping.data.mapper.toEntity
import woowacourse.shopping.model.Product
import javax.inject.Inject

class DefaultCartRepository @Inject constructor(private val dao: CartProductDao) : CartRepository {
    override suspend fun addCartProduct(product: Product) {
        dao.insert(product.toEntity())
    }

    override suspend fun cartProducts(): List<CartProductEntity> = dao.getAll()

    override suspend fun deleteCartProduct(id: Long) {
        dao.delete(id)
    }

    companion object {
        const val QUALIFIER_NAME = "RoomDB"
    }
}
