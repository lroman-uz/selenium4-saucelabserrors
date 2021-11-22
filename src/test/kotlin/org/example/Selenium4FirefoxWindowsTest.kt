package org.example

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URL

class Selenium4FirefoxWindowsTest {

    private lateinit var driver: WebDriver

    @Before
    fun setUp() {
        val browserOptions = FirefoxOptions()
        browserOptions.setCapability("platformName", "Windows 10")
        browserOptions.setCapability("browserVersion", "92")
        val sauceOptions: MutableMap<String, Any> = mutableMapOf()
        sauceOptions["username"] = SAUCELABS_USERNAME
        sauceOptions["accessKey"] = SAUCELABS_ACCESS_KEY
        sauceOptions["screenResolution"] = "2560x1600"
        sauceOptions["idleTimeout"] = 450
        sauceOptions["maxDuration"] = 5000
        sauceOptions["seleniumVersion"] = "4.0.0"
        browserOptions.setCapability("sauce:options", sauceOptions)
        driver = RemoteWebDriver(URL(GRID_ADDRESS), browserOptions)
    }

    @Test
    fun testUserzoom() {
        driver.get("https://www.userzoom.com")
    }

    @After
    fun tearDown() {
        driver.quit()
    }

    companion object {
        private const val SAUCELABS_USERNAME = ""
        private const val SAUCELABS_ACCESS_KEY = ""
        //Please test it executing the test in your EU-Central server as I saw the python file you send me with a test was executing in the US Server
        private const val GRID_ADDRESS = "https://ondemand.eu-central-1.saucelabs.com:443/wd/hub"
    }

}
