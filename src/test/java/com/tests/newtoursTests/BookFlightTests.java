package com.tests.newtoursTests;

import com.pageObjects.newtoursPages.*;
import com.tests.core.TestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTests extends TestBase {
    private String nrOfPassengers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"nrOfPassengers", "expectedPrice"})
    public void setupParameters(@Optional("2") String nrOfPassengers, @Optional("$1169 USD") String expectedPrice) {
        this.nrOfPassengers = nrOfPassengers;
        this.expectedPrice = expectedPrice;
    }

    @Test
    @Feature("Registration")
    @Severity(SeverityLevel.NORMAL)
    public void registrationPage() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goTo();
        registrationPage.enterUserDetails("selenium", "docker");
        registrationPage.enterUserCredentials("selenium", "docker");
        registrationPage.submit();
    }

    @Test(dependsOnMethods = "registrationPage")
    public void registrationConfirmationPage() {
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        registrationConfirmationPage.goToFlightDetailsPage();
    }

    @Test(dependsOnMethods = "registrationConfirmationPage")
    public void flightDetailsPage() {
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        flightDetailsPage.selectPassengers(nrOfPassengers);
        flightDetailsPage.goToFindFlightsPage();
    }

    @Test(dependsOnMethods = "flightDetailsPage")
    public void findFlightPage() {
        FindFlightPage findFlightPage = new FindFlightPage(driver);
        findFlightPage.submitFindFlightPage();
        findFlightPage.goToFlightConfirmationPage();
    }

    @Test(dependsOnMethods = "findFlightPage")
    public void flightConfirmationPage() {
        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
        String actualPrice = flightConfirmationPage.getPrice();
        Assert.assertEquals(actualPrice, expectedPrice);
    }
}
