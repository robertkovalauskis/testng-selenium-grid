package com.tests.searchmoduleTests;

import com.pageObjects.searchmodulePages.SearchPage;
import com.tests.core.TestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {

    @Test
    @Feature("Search")
    @Severity(SeverityLevel.NORMAL)
    @Parameters({"keyword"})
    public void search(@Optional("coca-cola") String keyword) throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.goTo();
        searchPage.doSearch(keyword);
        searchPage.goToVideos();
        int size = searchPage.getResult();

        Assert.assertTrue(size > 0);
    }
}
