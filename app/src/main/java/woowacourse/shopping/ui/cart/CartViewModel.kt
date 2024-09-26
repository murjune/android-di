package woowacourse.shopping.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import woowa.shopping.di.libs.android.ScopeViewModel
import woowacourse.shopping.data.CartRepository
import woowacourse.shopping.model.Product

class CartViewModel(
    private val cartRepository: CartRepository,
) : ScopeViewModel() {
    private val _cartProducts: MutableStateFlow<List<Product>> = MutableStateFlow(emptyList())
    val cartProducts: StateFlow<List<Product>> = _cartProducts.asStateFlow()

    private val _onCartProductDeleted: MutableLiveData<Boolean> = MutableLiveData(false)
    val onCartProductDeleted: LiveData<Boolean> get() = _onCartProductDeleted

    fun loadAllCartProducts() {
        viewModelScope.launch {
            _cartProducts.value = cartRepository.allCartProducts()
        }
    }

    fun deleteCartProduct(id: Long) {
        viewModelScope.launch {
            cartRepository.deleteCartProduct(id)
            _cartProducts.value = _cartProducts.value.filter { it.id != id }
            _onCartProductDeleted.value = true
        }
    }
}
