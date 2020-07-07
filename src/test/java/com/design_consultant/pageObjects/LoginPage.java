package com.design_consultant.pageObjects;

import org.apache.commons.math3.random.Well512a;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {

    WebDriver ldriver;
    public LoginPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(name="email")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(name="password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(xpath="//*[@id=\"top-of-form\"]/div/section/section/form/button")
    @CacheLookup
    WebElement btnLogin;

    @FindBy(xpath="//a[@href='/home']")
    @CacheLookup
    WebElement welcome;
    
    @FindBy(xpath="//a[@href='/account/logout']")
    @CacheLookup
    WebElement logout;
    ////*[@id="app"]/header/div/nav/a[2]

    public void setTxtEmail(String email)
    {
        txtEmail.clear();
        txtEmail.sendKeys(email);
    }

    public void setTxtPassword(String password)
    {
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public void btnClick()
    {
        btnLogin.click();
    }

    public void logoutBtnClick(){logout.click();}

    public boolean isHomePage()
    {
        try{
            Boolean s = welcome.isDisplayed();
            return s;
        } catch (Exception e) {
            return false;
        }

    }


}

