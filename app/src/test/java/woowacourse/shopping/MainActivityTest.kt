package woowacourse.shopping

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.matchers.nulls.shouldNotBeNull
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import woowa.shopping.di.libs.android.getViewModel
import woowa.shopping.di.libs.container.Containers
import woowacourse.shopping.ui.MainActivity
import woowacourse.shopping.ui.MainViewModel

@RunWith(RobolectricTestRunner::class)
class MainActivityTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @After
    fun tearDown() {
        Containers.clearContainersForTest()
    }

    @Test
    fun `Activity 실행 테스트`() {
        // given
        val activity =
            Robolectric
                .buildActivity(MainActivity::class.java)
                .create()
                .get()

        // then
        activity.shouldNotBeNull()
    }

    @Test
    fun `ViewModel 주입 테스트`() {
        // given
        val activity =
            Robolectric
                .buildActivity(MainActivity::class.java)
                .create()
                .get()
        // when & then
        shouldNotThrow<IllegalStateException> {
            activity.getViewModel<MainViewModel>()
        }
    }
}
