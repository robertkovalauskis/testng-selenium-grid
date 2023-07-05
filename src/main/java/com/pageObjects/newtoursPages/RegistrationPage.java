package com.pageObjects.newtoursPages;

import com.pageObjects.core.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends PageBase {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "firstName")
    private WebElement firstNameTxt;

    @FindBy(name = "lastName")
    private WebElement lastNameTxt;

    @FindBy(name = "email")
    private WebElement usernameTxt;

    @FindBy(name = "password")
    private WebElement passwordTxt;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(name = "register")
    private WebElement submitBtn;

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
        this.wait.until(ExpectedConditions.visibilityOf(this.firstNameTxt));
    }

    public void enterUserDetails(String firstname, String lastname) {
        this.firstNameTxt.sendKeys(firstname);
        this.lastNameTxt.sendKeys(lastname);
    }

    public void enterUserCredentials(String username, String password) {
        this.usernameTxt.sendKeys(username);
        this.passwordTxt.sendKeys(password);
        this.confirmPasswordTxt.sendKeys(password);
    }

    public void submit() {
        this.submitBtn.click();
    }
}
