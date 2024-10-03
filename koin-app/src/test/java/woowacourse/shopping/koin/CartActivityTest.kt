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
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.module.dsl.scopedOf
import org.koin.core.parameter.parametersOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.test.KoinTest
import woowacourse.shopping.koin.data.CartRepository
import woowacourse.shopping.koin.rule.KoinAndroidUnitTestRule
import woowacourse.shopping.koin.stub.StubCartRepository
import woowacourse.shopping.koin.ui.cart.CartActivity
import woowacourse.shopping.koin.ui.cart.CartViewModel
import woowacourse.shopping.koin.ui.cart.DateFormatter
import woowacourse.shopping.koin.utils.addLogger


/**
 * ref: https://insert-koin.io/docs/reference/koin-android/instrumented-testing/
 * */
@RunWith(AndroidJUnit4::class)
class CartActivityTest : KoinTest {
    @get:Rule
    val scenarioRule = activityScenarioRule<CartActivity>()
    private val scenario get() = scenarioRule.scenario

    private val instrumentedTestModule = module {
        scope<CartViewModel> {
            scopedOf(::StubCartRepository).bind<CartRepository>()
        }
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
        var scenario = launchActivity<CartActivity>().addLogger()
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

    @Test
    fun `DateFormatter 주입 테스트`() {
        // given
        scenario.onActivity { activity ->
            activity.get<DateFormatter> { parametersOf(activity) }.shouldNotBeNull()
        }
    }

    @Test
    fun `DateFormatter 는 액티비티 생명주기 동안 동일한 인스턴스 주입받는다`() {
        // given
        scenario.onActivity { activity ->
            val dateFormatter = activity.get<DateFormatter> { parametersOf(activity) }
            val dateFormatter2 = activity.get<DateFormatter> { parametersOf(activity) }
            dateFormatter shouldBe dateFormatter2
        }
    }

    @Test
    fun `DateFormatter 는 ConfigureChange 에도 동일한 인스턴스 주입받는다`() {
        // given
        var dateFormatter: DateFormatter? = null
        scenario.onActivity { activity ->
            dateFormatter = activity.get<DateFormatter> { parametersOf(activity) }
        }
        // when : 파괴 후 재생성
        scenario.recreate()
        // then
        scenario.onActivity { activity ->
            activity.get<DateFormatter> { parametersOf(activity) } shouldBe dateFormatter
        }
    }
}
