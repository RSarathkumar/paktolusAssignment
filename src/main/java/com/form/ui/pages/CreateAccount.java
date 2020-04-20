package com.form.ui.pages;


import com.form.ui.base.AbstractBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreateAccount extends AbstractBase {

    @FindBy(id ="fname")
     WebElement firstName;

    @FindBy(id="lname")
    private WebElement lastName;

    @FindBy(id = "email")
    private  WebElement email;

    @FindBy( id= "password")
    private WebElement password;

    @FindBy(id = "cpassword")
    private WebElement confirmPassword;

    @FindBy(id= "chktermpolicy")
    private WebElement termsCheckBox;

    @FindBy(xpath= "//a[contains(text(),'Terms of Use')]")
    private WebElement termsLink;

    @FindBy(xpath= "//div[@id='term_policy_div']//div[contains(@class,'modalContentDiv')]")
    private WebElement termsPopUp;

    @FindBy(xpath="//div[@id='term_policy_div']//a/img[@alt='close']")
    private WebElement closeTermsPopup;

    @FindBy(xpath = "//div[@id='privacy_policy_div']//a/img[@alt='close']")
    private WebElement closePrivacyPopup;

    @FindBy(xpath = "//div[@id='privacy_policy_div']//div[contains(@class,'modalContentDiv')]")
    private WebElement privacyPopup;

    @FindBy(xpath = "//a[contains(text(),'Privacy')]")
    private WebElement privacyLink;

    @FindBy(id = "createAccount")
    private WebElement createAccountButton;

    boolean status;

    public String firstNameData = "testAccountFirst";

    public String lastNameData = "testAccLast";

    public String emailData = "testcheck@gmail.com";

    public String invalidEmailData = "testcheck.com";

    public String passwordData = "password";

    public String invalidPasswordData = "pass";

    public String confirmPasswordData = "password";

    public String  unMatchConfirmPasswordData = "password1";

    public CreateAccount() {
        PageFactory.initElements(driver, this);
    }


    public boolean checkValidation(WebElement element){
        element.sendKeys("a");
        element.sendKeys(Keys.BACK_SPACE);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.getPageSource().contains("is required");

    }

    public boolean setFirstName(){
        status = checkValidation(firstName);
        firstName.clear();
        firstName.sendKeys(firstNameData);
        return status;
    }

    public boolean setLastName(){
        status =checkValidation(lastName);
        lastName.clear();
        lastName.sendKeys(lastNameData);
        return status;
    }

    public boolean setEmailField(){
        status = checkValidation(email);
        email.clear();
        email.sendKeys(emailData);
        return status;
    }


    public boolean  setInvalidEmailField(){
        email.clear();
        email.sendKeys(invalidEmailData);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//small[contains(text(),'The input is not a valid email')]"))).isDisplayed();
    }

    public boolean setPasswordField(){
        status = checkValidation(password);
        password.clear();
        password.sendKeys(passwordData);
        return status;
    }

    public boolean setConfirmPassword(){
        status = checkValidation(confirmPassword);
        confirmPassword.clear();
        confirmPassword.sendKeys(confirmPasswordData);
        return status;
    }

    public boolean setWrongConfirmPassword(){
        confirmPassword.clear();
        confirmPassword.sendKeys(unMatchConfirmPasswordData);
        return new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//small[contains(text(),'Password and its confirm are not the same')]"))).isDisplayed();
    }

    public boolean setInvalidPassword(){
        password.clear();
        password.sendKeys(invalidPasswordData);

        return new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//small[contains(text(),'Length of password should be between 5 and 16 characters')]"))).isDisplayed();
    }


    public boolean checkAndValidateTermsLink(){
        termsLink.click();
        boolean bool =  new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(termsPopUp)).isDisplayed();
        closeTermsPopup.click();
        return bool;
    }

    public boolean checkAndValidatePrivacyLink(){
        privacyLink.click();
        boolean bool =new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(privacyPopup)).isDisplayed();
        closePrivacyPopup.click();
        return bool;
    }



    public void clickTermsAndCreateAccount(){
         termsCheckBox.click();
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", createAccountButton);
    }

}
