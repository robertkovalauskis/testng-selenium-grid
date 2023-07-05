package com.pageObjects.newtoursPages;

import com.pageObjects.core.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FlightDetailsPage extends PageBase {
    public FlightDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "passCount")
    private WebElement passengers;

    @FindBy(name = "findFlights")
    private WebElement submitBtn;

    public void selectPassengers(String nrOfPassengers) {
        this.wait.until(ExpectedConditions.elementToBeClickable(passengers));
        Select select = new Select(passengers);
        select.selectByValue(nrOfPassengers);
    }

    public void goToFindFlightsPage() {
        this.submitBtn.click();
    }
}
