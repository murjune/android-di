package woowacourse.shopping.koin.data.mapper

import woowacourse.shopping.koin.data.CartProductEntity
import woowacourse.shopping.koin.model.Product

fun Product.toEntity(): CartProductEntity {
    return CartProductEntity(
        name = name,
        price = price,
        imageUrl = imageUrl,
    )
}
