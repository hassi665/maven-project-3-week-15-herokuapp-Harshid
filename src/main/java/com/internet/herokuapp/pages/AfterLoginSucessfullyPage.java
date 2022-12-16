package com.internet.herokuapp.pages;

import com.aventstack.extentreports.Status;
import com.internet.herokuapp.customlisteners.CustomListeners;
import com.internet.herokuapp.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AfterLoginSucessfullyPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Secure Area')]")
    WebElement getSuccessfullyLoginMessage;

    public String getTextAfterSuccessfulLogIn() {
        Reporter.log("Verification Text is " + getSuccessfullyLoginMessage.toString());
        CustomListeners.test.log(Status.PASS, "The login verification Message is \"" + getSuccessfullyLoginMessage.getText() + "\"");
        return getTextFromElement(getSuccessfullyLoginMessage);

    }
}
