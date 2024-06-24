package com.tutorialsninja.demo.steps;

import com.google.common.base.Verify;
import com.tutorialsninja.demo.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MyAccountsTestSteps {

    //1.1 Click on My Account Link., 2.1 Click on My Account Link., 3.1 Click on My Account Link.
    @When("Click on My Account Link")
    public void clickOnMyAccountLink() {
        new HomePage().clickOnMyAccountMenu();

    }

    //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
    // 2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
    // 3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
    //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
    //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
    @And("Call selectMyAccountOptions method and pass the parameter {string}")
    public void callSelectMyAccountOptionsMethodAndPassTheParameter(String accountOption) {
        new HomePage().selectMyAccountOptions(accountOption);
    }

    //1.3 Verify the text “Register Account”.
    @And("Verify the Register text {string}")
    public void verifyTheRegisterText(String registerText) {
        Assert.assertEquals(new RegisterPage().getRegisterAccountText(), registerText, "Register Account text is not displayed");
    }

    //2.3 Verify the text “Returning Customer”.
    @Then("Verify the text on login page {string}")
    public void verifyTheTextOnLoginPage(String expectedMessage) {
        Assert.assertEquals(new LoginPage().getReturningCustomerText(), expectedMessage, "Returning Customer text is not displayed");
    }


    //3.3 Enter First Name
    @And("Enter First Name {string}")
    public void enterFirstName(String firstName) {
        new RegisterPage().enterTextToFirstName(firstName);
    }

    //3.4 Enter Last Name
    @And("Enter Last Name {string}")
    public void enterLastName(String lastName) {
        new RegisterPage().enterTextToLastName(lastName);
    }

    //3.5 Enter Email
    @And("Enter Email {string}")
    public void enterEmail(String email) {
        new RegisterPage().enterTextToEmail(email);
    }

    //3.6 Enter Telephone
    @And("Enter Telephone {string}")
    public void enterTelephone(String telephone) {
        new RegisterPage().enterTextToTelephone(telephone);
    }

    //3.7 Enter Password
    @And("Enter Password {string}")
    public void enterPassword(String password) {
        new RegisterPage().enterTextToPassword(password);
    }

    //3.8 Enter Password Confirm
    @And("Enter Password Confirm {string}")
    public void enterPasswordConfirm(String passwordConfirm) {
        new RegisterPage().enterTextToPasswordConfirm(passwordConfirm);
    }

    //3.9 Select Subscribe Yes radio button
    @And("Select Subscribe Yes radio button")
    public void selectSubscribeYesRadioButton() {
        new RegisterPage().clickOnYesRadioOption();
    }

    //3.10 Click on Privacy Policy check box
    @And("Click on Privacy Policy check box")
    public void clickOnPrivacyPolicyCheckBox() {
        new RegisterPage().clickOnTermsAndAgreement();
    }

    //3.11 Click on Continue button
    @And("Click on Continue button")
    public void clickOnContinueButton() {
        new RegisterPage().clickOnContinueButton();
    }

    //3.12 Verify the message “Your Account Has Been Created!”
    @Then("Verify the  message {string}")
    public void verifyTheMessage(String expectedMessage) {
        Assert.assertEquals(new AccountPage().getAccountCreatedSuccessMessageText(), expectedMessage, "Your Account Has Been Created! text is not matched");
    }

    //3.13 Click on Continue button
    //4.11 Click on Continue button
    @And("Click on Continue button from my account")
    public void clickOnContinueButtonFromMyAccount() {
        new AccountPage().clickOnContinueButton();
    }

    //3.16 Verify the text “Account Logout”
    //4.10 Verify the text “Account Logout”
    @Then("Verify the account logout text {string}")
    public void verifyTheAccountLogoutText(String expectedText) {
        Assert.assertEquals(new LogoutPage().getAccountLogoutText(), expectedText, "Account Logout text is not displayed");
    }


    //4.3 Enter Email address
    @And("Enter Email address {string}")
    public void enterEmailAddress(String email) {
        new LoginPage().enterTextToEmailAddress(email);
    }

    //4.5 Enter Password
    @And("Enter login Password {string}")
    public void enterLoginPassword(String password) {
        new LoginPage().enterTextToPassword(password);
    }

    //4.6 Click on Login button
    @And("Click on Login button")
    public void clickOnLoginButton() {
        new LoginPage().clickOnLoginButton();
    }

    //4.7 Verify text “My Account”
    @And("Verify my account text {string}")
    public void verifyMyAccountText(String expectedText) {
        Assert.assertEquals(new AccountPage().getMyAccountText(), expectedText, "My Account text is not displayed");
    }
}
