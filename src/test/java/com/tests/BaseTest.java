package com.tests;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setupDriver() throws MalformedURLException {
        String host = "localhost";
        MutableCapabilities mc;

        if (System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            mc = new FirefoxOptions();
        } else {
            mc = new ChromeOptions(); // default browser chrome
        }

        if (System.getProperty("HUB_HOST") != null) {
            host = System.getProperty("HUB_HOST");
        }

        String completeUrl = "http://" + host + ":4444/wd/hub";
        //RemoteWebDriver doesn't know what browser we need to use
        // that's why we specify mc (MutableCapabilities)
        this.driver = new RemoteWebDriver(new URL(completeUrl), mc);
    }

    @AfterTest
    public void quitBrowser() {
        this.driver.quit();
    }
}
