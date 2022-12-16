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
public class LoginTest extends BaseTest {

    LoginPage loginPage;
    AfterLoginSucessfullyPage afterLoginSucessfullyPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {

        loginPage = new LoginPage();

        afterLoginSucessfullyPage = new AfterLoginSucessfullyPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyTheUsernameErrorMessage() {

        loginPage.enterUserName("tomsmith1");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLogInButton();

        Assert.assertEquals(loginPage.getErrorMessageForInvalidUserName(),
                "Your username is invalid!\n" + "×", "There is no Error");
    }


    @Test(groups = "regression")
    public void verifyThePasswordErrorMessage() {

        loginPage.enterUserName("tomsmith");
        loginPage.enterPassword("SuperSecretPassword");
        loginPage.clickOnLogInButton();

        Assert.assertEquals(loginPage.getErrorMessageForInvalidPassword(), "Your password is invalid!\n" +
                "×", "There is no Error");
    }


}
