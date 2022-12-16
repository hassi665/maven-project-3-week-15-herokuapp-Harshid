package com.internet.herokuapp.pages;


import com.aventstack.extentreports.Status;
import com.internet.herokuapp.customlisteners.CustomListeners;
import com.internet.herokuapp.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(id = "username")
    WebElement userNameField;
    @CacheLookup
    @FindBy(id = "password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(xpath = "//i[contains(text(),'Login')]")
    WebElement logInButton;
    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),\"Your username is invalid!\")]")
    WebElement errorMessageForInvalidUser;

    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),\"Your password is invalid!\")]")
    WebElement errorMessageForInvalidPass;


    public void enterUserName(String username) {
        Reporter.log("Enter username " + username + " in field " + userNameField.toString());
        sendTextToElement(userNameField, username);
        CustomListeners.test.log(Status.PASS, "Enter username \"" + username + "\"");
    }

    public void enterPassword(String password) {
        Reporter.log("Enter password " + password + " in field " + passwordField.toString());
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS, "Enter Password \"" + password + "\"");
    }

    public void clickOnLogInButton() {
        Reporter.log("Click on Login Button " + logInButton.toString());
        clickOnElement(logInButton);
        CustomListeners.test.log(Status.PASS, "Click on login Button ");
    }

    public String getErrorMessageForInvalidUserName() {
        Reporter.log("Error message for Invalid Username " + errorMessageForInvalidUser.toString());
        CustomListeners.test.log(Status.PASS, "Error message : \"" + errorMessageForInvalidUser.getText() + "\"");
        return getTextFromElement(errorMessageForInvalidUser);

    }

    public String getErrorMessageForInvalidPassword() {
         Reporter.log("Error message for Invalid Password" + errorMessageForInvalidPass.toString());
        CustomListeners.test.log(Status.PASS, "Error message : \"" + errorMessageForInvalidPass.getText() + "\"");
        return getTextFromElement(errorMessageForInvalidPass);

    }
}
