package org.example

import org.junit.Before
import org.junit.Test
import org.openqa.selenium.MutableCapabilities
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URL

class Selenium4iOSTest {

    private lateinit var driver: WebDriver

    @Before
    fun setUp() {
        val caps = MutableCapabilities()
        caps.setCapability("appium:deviceName","iPhone X Simulator")
        caps.setCapability("appium:deviceOrientation", "portrait")
        caps.setCapability("appium:platformVersion", "15.0")
        caps.setCapability("platformName", "iOS")
        caps.setCapability("browserName", "Safari")
        val sauceOptions: MutableMap<String, Any> = mutableMapOf()
        sauceOptions["username"] = SAUCELABS_USERNAME
        sauceOptions["accessKey"] = SAUCELABS_ACCESS_KEY
        sauceOptions["idleTimeout"] = 450
        sauceOptions["appiumVersion"] = "1.22.0"
        caps.setCapability("sauce:options", sauceOptions)
        driver = RemoteWebDriver(URL(GRID_ADDRESS), caps)
    }

    @Test
    fun testUserzoom() {
        driver.get("https://www.userzoom.com")
    }


    companion object {
        private const val SAUCELABS_USERNAME = ""
        private const val SAUCELABS_ACCESS_KEY = ""
        //Please test it executing the test in your EU-Central server as I saw the python file you send me with a test was executing in the US Server
        private const val GRID_ADDRESS = "https://ondemand.eu-central-1.saucelabs.com:443/wd/hub"
    }

}