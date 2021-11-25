package org.example

import org.json.JSONObject
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URL

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
        val sauceOptions: MutableMap<String, Any> = mutableMapOf()
        val opts = JSONObject()
        opts.put("executable", "https://gist.githubusercontent.com/lroman-uz/5ab343d765ffb8cb157f8362debbe052/raw/6a4af3c9b990603ae58acf7a090be659b5fdf136/videos.bat")
        opts.put("background", "false")
        opts.put("timeout", "360")
        sauceOptions["prerun"] = opts
        sauceOptions["username"] = SAUCELABS_USERNAME
        sauceOptions["accessKey"] = SAUCELABS_ACCESS_KEY
        sauceOptions["idleTimeout"] = 450
        sauceOptions["maxDuration"] = 5000
        sauceOptions["seleniumVersion"] = "4.1.0"
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
