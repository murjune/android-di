package woowacourse.shopping.koin.study

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.mockk.every
import io.mockk.mockkClass
import org.junit.jupiter.api.extension.RegisterExtension
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.get
import org.koin.test.inject
import org.koin.test.junit5.KoinTestExtension
import org.koin.test.junit5.mock.MockProviderExtension
import org.koin.test.mock.declareMock
import kotlin.test.Test

/**
 * ref: https://insert-koin.io/docs/reference/koin-test/testing
 * */
class MyTest : KoinTest {
    class ComponentA {
        fun hello() = "Hello Koin"
    }

    class ComponentB(val a: ComponentA)

    @JvmField
    @RegisterExtension
    val koinTestExtension = KoinTestExtension.create {
        modules(
            module {
                single { ComponentA() }
                single { ComponentB(get()) }
            }
        )
    }

    @JvmField
    @RegisterExtension
    val mockProvider = MockProviderExtension.create { clazz ->
        mockkClass(clazz)
    }

    @Test
    fun `koin inject test`() {
        val componentB: ComponentB by inject()
        val componentA = get<ComponentA>()
        // then
        componentA shouldBe componentB.a
    }

    @Test
    fun `successful change module`() {
        // when
        loadKoinModules(
            module {
                factory { ComponentA() }
            }
        )
        // then
        val componentA = get<ComponentA>()
        val componentB = get<ComponentB>()
        componentA shouldNotBe componentB.a
    }

    @Test
    fun `mocking ComponentA`() {
        // Get ComponentA
        val componentA = get<ComponentA>()
        componentA.hello() shouldBe "Hello Koin"
        // Mock ComponentA
        val mockComponentA = declareMock<ComponentA>() {
            every { hello() } returns "Hello Mock"
        }
        mockComponentA.hello() shouldBe "Hello Mock"
    }
}