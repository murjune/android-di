package woowacourse.shopping.koin

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.dsl.module
import woowacourse.shopping.koin.data.CartRepository
import woowacourse.shopping.koin.stub.StubCartRepository
import woowacourse.shopping.koin.ui.cart.CartActivity
import woowacourse.shopping.koin.ui.cart.CartViewModel


/**
 * ref: https://insert-koin.io/docs/reference/koin-android/instrumented-testing/
 * */
@RunWith(AndroidJUnit4::class)
class CartActivityTest {
    @get:Rule
    val scenarioRule = activityScenarioRule<CartActivity>()
    private val scenario get() = scenarioRule.scenario

    private val instrumentedTestModule = module {
        factory<CartRepository> { StubCartRepository() }
    }

    @get:Rule
    val koinTestRule = KoinAndroidUnitTestRule(
        instrumentedTestModule
    )

    @Test
    fun `Activity 실행 테스트`() {
        scenario.onActivity { activity ->
            activity.shouldNotBeNull()
        }
    }

    @Test
    fun `ViewModel 주입 테스트`() {
        scenario.onActivity {
            val activityViewModel = it.getViewModel<CartViewModel>()
            val viewModel = it.getViewModel<CartViewModel>()
            activityViewModel shouldBe viewModel
        }
    }

    @Test
    fun `Configuration change 시 ViewModel 유지 테스트`() {
        var preViewModel: CartViewModel? = null
        scenario.onActivity {
            preViewModel = it.getViewModel()
        }
        // configuration change
        scenario.recreate()
        // then
        scenario.onActivity {
            it.getViewModel<CartViewModel>() shouldBe preViewModel
        }
    }

    @Test
    fun `Destroy 시 ViewModel 파괴 테스트`() {
        var scenario = launchActivity<CartActivity>()
        var preViewModel: CartViewModel? = null
        scenario.onActivity {
            preViewModel = it.getViewModel()
        }
        // configuration change
        scenario.moveToState(Lifecycle.State.DESTROYED)
        scenario = launchActivity()
        // then
        scenario.onActivity {
            it.getViewModel<CartViewModel>() shouldNotBe preViewModel
        }
    }
}
