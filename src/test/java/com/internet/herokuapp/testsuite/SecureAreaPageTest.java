package com.internet.herokuapp.testsuite;

import com.internet.herokuapp.customlisteners.CustomListeners;
import com.internet.herokuapp.pages.AfterLoginSucessfullyPage;
import com.internet.herokuapp.pages.LoginPage;
import com.internet.herokuapp.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class SecureAreaPageTest extends BaseTest {

    LoginPage loginPage;
    AfterLoginSucessfullyPage afterLoginSucessfullyPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {

        loginPage = new LoginPage();

        afterLoginSucessfullyPage = new AfterLoginSucessfullyPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void userCanLoginSuccessfully() {

        loginPage.enterUserName("tomsmith");

        loginPage.enterPassword("SuperSecretPassword!");

        loginPage.clickOnLogInButton();

        //calling Wait Method
        afterLoginSucessfullyPage.waitUntilVisibilityOfElementLocated(By.xpath("//h2[text() =' Secure Area']"), 20);

        Assert.assertEquals(afterLoginSucessfullyPage.getTextAfterSuccessfulLogIn(), "Secure Area", "Login is not successfully");
    }
}
