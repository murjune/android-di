package woowacourse.shopping.koin

import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.dsl.module
import woowacourse.shopping.koin.data.CartRepository
import woowacourse.shopping.koin.data.ProductRepository
import woowacourse.shopping.koin.rule.KoinAndroidUnitTestRule
import woowacourse.shopping.koin.stub.StubCartRepository
import woowacourse.shopping.koin.stub.StubProductRepository
import woowacourse.shopping.koin.ui.MainActivity
import woowacourse.shopping.koin.ui.MainViewModel

/**
 * ref: https://insert-koin.io/docs/reference/koin-android/instrumented-testing/
 * */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    private val instrumentedTestModule = module {
        factory<ProductRepository> { StubProductRepository() }
        factory<CartRepository> { StubCartRepository() }
    }

    @get:Rule
    val scenarioRule = activityScenarioRule<MainActivity>()
    private val scenario get() = scenarioRule.scenario

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
            val activityViewModel = it.getViewModel<MainViewModel>()
            val viewModel = it.getViewModel<MainViewModel>()
            activityViewModel shouldBe viewModel
        }
    }

    @Test
    fun `Configuration change 시 ViewModel 유지 테스트`() {
        val scenario = launchActivity<MainActivity>()
        var preViewModel: MainViewModel? = null
        scenario.onActivity {
            preViewModel = it.getViewModel()
        }
        // configuration change
        scenario.recreate()
        // then
        scenario.onActivity {
            it.getViewModel<MainViewModel>() shouldBe preViewModel
        }
    }
}