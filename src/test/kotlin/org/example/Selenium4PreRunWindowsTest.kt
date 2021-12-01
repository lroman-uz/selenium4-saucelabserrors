package org.example

import org.json.simple.JSONObject
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URL
import java.util.*

class Selenium4PreRunWindowsTest {

    private lateinit var driver: WebDriver

    @Before
    fun setUp() {
        val browserOptions = ChromeOptions()
        browserOptions.addArguments("--use-fake-device-for-media-stream")
        browserOptions.addArguments("--use-fake-ui-for-media-stream")
        browserOptions.addArguments("--no-sandbox")
        browserOptions.addArguments("--use-file-for-fake-audio-capture=C:\\Users\\Administrator\\Desktop\\miAmigoElPuma.wav")
        browserOptions.addArguments("--use-file-for-fake-video-capture=C:\\Users\\Administrator\\Desktop\\fake_webcam_salma_hayek.y4m")
        browserOptions.addArguments("--disable-gpu")
        browserOptions.setCapability("platformName", "Windows 10")
        browserOptions.setCapability("browserVersion", "93")
        val sauceOptions: HashMap<String, Any> = hashMapOf()
        val opts = JSONObject()
        opts["executable"] = "https://gist.githubusercontent.com/KevinLinSL/fa21eb0566924eff9af2d36d1f52f9e9/raw/3dcb2c67ac1b2899c9cff95582173e04e396fd99/powershellcurl.bat"
        opts["background"] = false
        opts["timeout"] = 240
        val arr = LinkedList<String>()
        arr.add("/S")
        arr.add("-a")
        arr.add("-q")
        opts["args"] = arr
        sauceOptions["username"] = SAUCELABS_USERNAME
        sauceOptions["accessKey"] = SAUCELABS_ACCESS_KEY
        sauceOptions["idleTimeout"] = 450
        sauceOptions["maxDuration"] = 5000
        sauceOptions["seleniumVersion"] = "4.1.0"
        sauceOptions["prerun"] = opts
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
