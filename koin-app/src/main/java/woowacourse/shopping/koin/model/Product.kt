package woowacourse.shopping.koin.model

data class Product(
    val id: Long,
    val name: String,
    val price: Int,
    val imageUrl: String,
    val createdAt: Long,
)