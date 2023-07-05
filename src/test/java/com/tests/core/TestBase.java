package com.tests.core;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {

    protected WebDriver driver;

    @BeforeTest
    public void setupDriver() {
        /* Choose WebDriver initialization method */
        // setupDriverToRunTestsOnSeleniumGrid();
        setupDriverToRunTestsLocally();
    }

    @AfterTest
    public void quitBrowser() {
        this.driver.quit();
    }

    public void setupDriverToRunTestsLocally() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void setupDriverToRunTestsOnSeleniumGrid() throws MalformedURLException {
        String host = "localhost";
        MutableCapabilities mc;

        if (System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            mc = new FirefoxOptions();
        } else {
            mc = new ChromeOptions(); // use Chrome by default
        }

        if (System.getProperty("HUB_HOST") != null) {
            host = System.getProperty("HUB_HOST");
        }

        String completeUrl = "http://" + host + ":4444/wd/hub";

        // RemoteWebDriver doesn't know what browser we need to use
        // that's why we specify options (DriverOptions)
        this.driver = new RemoteWebDriver(new URL(completeUrl), mc);
        driver.manage().window().maximize();
    }
}