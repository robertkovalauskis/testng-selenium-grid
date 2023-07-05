package com.pageObjects.newtoursPages;

import com.pageObjects.core.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FindFlightPage extends PageBase {
    public FindFlightPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "reserveFlights")
    private WebElement firstSubmitBtn;

    @FindBy(name = "buyFlights")
    private WebElement secondSubmitBtn;

    public void submitFindFlightPage() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.firstSubmitBtn));
        this.firstSubmitBtn.click();
    }

    public void goToFlightConfirmationPage() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.secondSubmitBtn));
        this.secondSubmitBtn.click();
    }
}
