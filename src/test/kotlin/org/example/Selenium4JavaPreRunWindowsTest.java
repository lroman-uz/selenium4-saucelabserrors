package org.example;

import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Selenium4JavaPreRunWindowsTest {

    private WebDriver driver;
    private static final String SAUCELABS_USERNAME = "";
    private static final String SAUCELABS_ACCESS_KEY = "";
    private static final String GRID_ADDRESS = "https://ondemand.eu-central-1.saucelabs.com:443/wd/hub";

    @Before
    public void setUp() throws MalformedURLException {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.addArguments("--use-fake-device-for-media-stream");
        browserOptions.addArguments("--use-fake-ui-for-media-stream");
        browserOptions.addArguments("--no-sandbox");
        browserOptions.addArguments("--use-file-for-fake-audio-capture=C:\\Users\\Administrator\\Desktop\\miAmigoElPuma.wav");
        browserOptions.addArguments("--use-file-for-fake-video-capture=C:\\Users\\Administrator\\Desktop\\fake_webcam_salma_hayek.y4m");
        browserOptions.addArguments("--disable-gpu");
        browserOptions.setCapability("platformName", "Windows 10");
        browserOptions.setCapability("browserVersion", "93");
        Map<String, Object> sauceOptions = new HashMap<String, Object>();
        JSONObject opts = new JSONObject();
        opts.put("executable", "https://gist.githubusercontent.com/KevinLinSL/fa21eb0566924eff9af2d36d1f52f9e9/raw/3dcb2c67ac1b2899c9cff95582173e04e396fd99/powershellcurl.bat");
        opts.put("background", "false");
        opts.put("timeout", "360");
        sauceOptions.put("prerun", opts);
        sauceOptions.put("username", SAUCELABS_USERNAME);
        sauceOptions.put("accessKey", SAUCELABS_ACCESS_KEY);
        sauceOptions.put("idleTimeout", 450);
        sauceOptions.put("maxDuration", 5000);
        sauceOptions.put("seleniumVersion", "4.1.0");
        browserOptions.setCapability("sauce:options", sauceOptions);
        driver = new RemoteWebDriver(new URL(GRID_ADDRESS), browserOptions);
    }

    @Test
    public void testUserzoom() {
        driver.get("https://www.userzoom.com");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
