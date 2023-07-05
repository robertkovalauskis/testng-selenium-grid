package com.pageObjects.newtoursPages;

import com.pageObjects.core.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class FlightConfirmationPage extends PageBase {
    public FlightConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//font[contains(text(), 'Confirmation')]")
    private WebElement flightConfirmationHeader;

    @FindBy(xpath = "//font[contains(text(), 'USD')]")
    private List<WebElement> prices;

    @FindBy(linkText = "SIGN-OFF")
    private WebElement signOffLink;

    public String getPrice() {
        this.wait.until(ExpectedConditions.visibilityOf(this.flightConfirmationHeader));
        System.out.println(this.flightConfirmationHeader.getText());
        System.out.println(this.prices.get(1).getText());
        String price = this.prices.get(1).getText();
        this.signOffLink.click();
        return price;
    }
}
