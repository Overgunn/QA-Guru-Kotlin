package general

import com.typesafe.config.ConfigFactory
import java.io.File

object PropertiesHocon {
    private const val DEFAULT_CONF_FILE = "/hoconProperties.conf"

    val get: HoconProps by lazy {
        val fileName = System.getProperty("hocon_config", DEFAULT_CONF_FILE)

        val config = ConfigFactory
            .parseFile(
                File(PropertiesHocon::class.java.getResource(fileName)?.toURI()
                    ?: throw IllegalStateException("Config file '$fileName' not found"))
            )
            .resolve()

        HoconProps(
            browserName = config.getString("browser.name"),
            browserVersion = config.getString("browser.version"),
            frontendUrl = config.getString("frontend.url"),
            backendUrl = config.getString("backend.url"),
            backendApiVersion = config.getString("backend.api.version"),
            moonHost = config.getString("moon.host")
        )
    }
    data class HoconProps(
        val browserName: String,
        val browserVersion: String,
        val frontendUrl: String,
        val backendUrl: String,
        val backendApiVersion: String,
        val moonHost: String,
    )
}