package com.design_consultant.testCases;

import com.design_consultant.pageObjects.LoginPage;
import com.design_consultant.utilities.XLUtils;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.IOException;

public class TC_loginDDT_002 extends BaseClass {

    @Test(dataProvider = "LoginData")
    public void loginddt(String user, String pass) throws InterruptedException, IOException {

        Thread.sleep(6000);
        LoginPage lp = new LoginPage(driver);
        Thread.sleep(6000);
        lp.setTxtEmail(user);
        lp.setTxtPassword(pass);
        Thread.sleep(6000);
        lp.btnClick();
        Thread.sleep(6000);



        if(lp.isHomePage()) {
            Thread.sleep(6000);
            lp.logoutBtnClick();
            logger.info("Home page is displayed");
            Thread.sleep(3000);
            Assert.assertTrue(true);
        }
        else {
            captureScreen(driver,"loginTest");
            driver.switchTo().defaultContent();
            Thread.sleep(3000);
            Assert.assertTrue(false);
            logger.warning("Issue with displaying home page");


        }


    }

    @DataProvider(name="LoginData")
    Object[][] getData() throws IOException {
        String path = System.getProperty("user.dir")+"/src/test/java/com/design_consultant/testData/LoginData.xlsx";
        int rownum = XLUtils.getRowCount(path,"Sheet1");
        int colcount = XLUtils.getCellCount(path,"Sheet1",1);

        String loginData[][] = new String[rownum][colcount];

        for(int i=1;i<=rownum;i++)
        {
            for(int j = 0;j<colcount;j++)
            {
                loginData[i-1][j] = XLUtils.getCellData(path,"Sheet1",i,j);
            }
        }
        return loginData;
    }
}
