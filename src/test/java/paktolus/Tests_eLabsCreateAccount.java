package paktolus;

import com.form.ui.base.AbstractBase;
import com.form.ui.pages.CreateAccount;
import com.form.ui.util.AbstractUtil;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Tests_eLabsCreateAccount  extends AbstractBase {

    private WebDriver driver;
    AbstractUtil abstractUtil;
    CreateAccount createAccount;

    public Tests_eLabsCreateAccount(){ super();}

    @BeforeSuite
    public void setUp() throws InterruptedException {
        initialization();
        abstractUtil = new AbstractUtil();
        createAccount = new CreateAccount();

    }
    @Test(priority = 1)
    public void setFirstName (){
        Assert.assertTrue(createAccount.setFirstName(), "The first name is not set");
    }

    @Test(priority = 2)
    public void setLastName (){
        Assert.assertTrue(createAccount.setLastName(), "The last name is not set");
    }

    @Test(priority = 3)
    public void setInvalidEmailAndVerifyValidation (){
        Assert.assertTrue(createAccount.setInvalidEmailField(), "The invalid email is not validated");
    }

    @Test(priority = 4)
    public void setEmail (){
        Assert.assertTrue(createAccount.setEmailField(),"Email is not set");
    }

    @Test(priority = 5)
    public void setInvalidPassword (){
        Assert.assertTrue(createAccount.setInvalidPassword(), "Invalid validation is not set");
    }

    @Test(priority = 6)
    public void setPassword (){
        Assert.assertTrue(createAccount.setPasswordField(), "The password is not set");
    }


    @Test(priority = 7)
    public void setIncorrectConfirmPassword (){
        Assert.assertTrue(createAccount.setWrongConfirmPassword(), "The wrong confirm password is" +
                " set and its working, which should not");
    }


     @Test(priority = 8)
    public void setConfirmPassword (){
        Assert.assertTrue(createAccount.setConfirmPassword(),"The confirm password is not set");
    }

    @Test(priority = 9)
    public void checkTermsLink(){
       Assert.assertTrue(createAccount.checkAndValidateTermsLink(), "Terms pop up is missing");
    }
    @Test(priority = 10)
    public void checkPrivacyLink(){
        Assert.assertTrue(createAccount.checkAndValidatePrivacyLink(), "Privacy pop up is ,missing");
    }

    @Test(priority = 11)
    public void enableTermsCheckBoxandsubmit(){
           createAccount.clickTermsAndCreateAccount();
    }

    @AfterSuite
    public void tearDown(){
        closeBrowser();
    }

}
