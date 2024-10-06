package woowacourse.shopping.koin.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import woowacourse.shopping.koin.databinding.ItemProductBinding
import woowacourse.shopping.koin.model.Product

class ProductViewHolder(
    private val binding: ItemProductBinding,
    onClickProduct: (product: Product) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.root.setOnClickListener {
            onClickProduct(binding.item ?: return@setOnClickListener)
        }
    }

    fun bind(product: Product) {
        binding.item = product
    }

    companion object {
        fun from(
            parent: ViewGroup,
            onClickProduct: (product: Product) -> Unit,
        ): ProductViewHolder {
            val binding =
                ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ProductViewHolder(binding, onClickProduct)
        }
    }
}
