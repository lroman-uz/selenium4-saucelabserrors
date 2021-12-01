package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.IOException;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import java.net.URL;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import java.util.*;
import org.json.simple.JSONObject;
 
public class SampleSauceTest {
 
  public WebDriver driver;

  @Before
  public void setUp() throws Exception {
    String USERNAME = "";
    String ACCESS_KEY = "";
    String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
    
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.addArguments("--use-fake-device-for-media-stream");
        browserOptions.addArguments("--use-fake-ui-for-media-stream");
        browserOptions.addArguments("--no-sandbox");
        browserOptions.addArguments("--use-file-for-fake-audio-capture=C:\\Users\\Administrator\\Desktop\\miAmigoElPuma.wav");
        browserOptions.addArguments("--use-file-for-fake-video-capture=C:\\Users\\Administrator\\Desktop\\fake_webcam_salma_hayek.y4m");
        browserOptions.addArguments("--disable-gpu");
        browserOptions.setCapability("platformName", "Windows 10");
        browserOptions.setCapability("browserVersion", "93");

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("executable", "https://gist.githubusercontent.com/KevinLinSL/fa21eb0566924eff9af2d36d1f52f9e9/raw/3dcb2c67ac1b2899c9cff95582173e04e396fd99/powershellcurl.bat");
        jsonObj.put("background", "false");
        jsonObj.put("timeout", "240");

        LinkedList<String> arr = new LinkedList<String>();
        arr.add("/S");
        arr.add("-a");
        arr.add("-q");
        jsonObj.put("args", arr);

        Map<String, Object> sauceOptions = new HashMap<>();

        sauceOptions.put("prerun",jsonObj);
        System.out.print(jsonObj);
        sauceOptions.put("seleniumVersion", "4.1.0");
        browserOptions.setCapability("sauce:options", sauceOptions);

        driver = new RemoteWebDriver(new URL(URL), browserOptions);
  }

  @Test
  public void testMethod() throws IOException, InterruptedException {
    driver.get("https://www.google.com");
  }

  @After
  public void tearDown() {
    driver.quit();
  }
}