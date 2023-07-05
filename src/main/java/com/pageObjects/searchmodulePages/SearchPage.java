package com.pageObjects.searchmodulePages;

import com.pageObjects.core.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchPage extends PageBase {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "q")
    private WebElement searchTxt;

    @FindBy(css = "button[aria-label='Search']")
    private WebElement searchBtn;

    @FindBy(linkText = "Videos")
    private WebElement videosLink;

    @FindBy(className = "tile--vid")
    private List<WebElement> allVideos;

    public void goTo() {
        this.driver.get("https://duckduckgo.com/");
    }

    public void doSearch(String keyword) throws InterruptedException {
        this.wait.until(ExpectedConditions.visibilityOf(this.searchTxt));
        this.searchTxt.sendKeys(keyword);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.searchTxt));
        this.searchBtn.click();
    }

    public void goToVideos() {
        this.wait.until(ExpectedConditions.visibilityOf(this.videosLink));
        this.videosLink.click();
    }

    public int getResult() {
        By by = By.className("tile--vid");
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 0));
        System.out.println("Search Result : " + this.allVideos.size());
        return this.allVideos.size();
    }
}
