package backend

import general.Config
import general.PropertiesHocon
import general.TestWatcherExtension
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import io.kotest.matchers.string.shouldNotBeEmpty
import io.kotest.matchers.string.shouldStartWith
import org.junit.jupiter.api.Assumptions.assumeTrue
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestWatcherExtension::class)
class PropertiesTest {

    @Test
    @DisplayName("Positive test: read and check example.properties")
    fun testPropertiesLoading() {
        System.setProperty("env_config", "/example.properties")
        val props = Config.get
        println("Properties file: $props")
        props.browserName shouldBe "chrome"
        props.browserVersion.shouldNotBeEmpty()
        props.frontendUrl shouldStartWith "http"
        props.backendUrl shouldStartWith "http"
        props.backendApiVersion.matches(Regex("v\\d+")) shouldBe true
        props.moonHost shouldContain "wd/hub"
    }

    @Test
    @DisplayName("Positive test: read and check hocon .conf properties")
    fun testHoconLoading() {
        System.setProperty("hocon_config", "/hoconProperties.conf")
        val props = PropertiesHocon.get
        println("Hocon file: $props")
        props.browserName shouldBe "firefox"
        props.browserVersion.shouldNotBeEmpty()
        props.frontendUrl shouldStartWith "http"
        props.backendUrl shouldStartWith "http"
        props.backendApiVersion.matches(Regex("v\\d+")) shouldBe true
        props.moonHost shouldContain "wd/hub"
    }

    @Test
    @DisplayName("Negative test watcher check: wrong browser name")
    fun checkWatcherOnFailed() {
        val props = PropertiesHocon.get
        props.browserName shouldBe "chrome"
    }

    @Test
    @DisplayName("Aborted test check: skip if not PROD env")
    fun checkWatcherOnAborted() {
        val props = PropertiesHocon.get
        assumeTrue(
            props.frontendUrl.contains("PROD"),
            "Skipping: not a PROD environment"
        )
        props.frontendUrl shouldContain "staging"
    }

    @Test
    @Disabled("DISABLED")
    @DisplayName("Disabled test check: intentionally skipped")
    fun checkWatcherOnDisabled() {
        val props = PropertiesHocon.get
        props.browserName shouldBe "chrome"
    }

}