package com.design_consultant.testCases;

import com.design_consultant.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_loginTest_001 extends BaseClass {

    @Test
    public void loginTest() throws InterruptedException, IOException {
        driver.get(baseURL);
        logger.info("Open URL");
        Thread.sleep(3000);
        LoginPage lp = new LoginPage(driver);
        Thread.sleep(3000);
        lp.setTxtEmail(username);
        logger.info("Username is entered");
        lp.setTxtPassword(password);
        logger.info("password is entered");
        lp.btnClick();
        logger.info("hit login button");

        if(lp.isHomePage()) {
            Thread.sleep(6000);
            logger.info("Home page is displayed");
            lp.logoutBtnClick();
            Thread.sleep(6000);
            Assert.assertTrue(true);
        }
        else {
            captureScreen(driver,"loginTest");
            Assert.assertTrue(false);
            logger.info("Issue with displaying home page");

        }
    }

}
