package com.pageObjects.newtoursPages;

import com.pageObjects.core.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationConfirmationPage extends PageBase {
    public RegistrationConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "sign-in")
    private WebElement signinLink;

    @FindBy(id = "flight-link")
    private WebElement flightsLink;

    public void goToFlightDetailsPage() {
        this.wait.until(ExpectedConditions.visibilityOf(this.flightsLink));
        this.flightsLink.click();
    }
}
