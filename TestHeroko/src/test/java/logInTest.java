import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class logInTest {
    SoftAssert Soft=new SoftAssert();
    logIn driver=new logIn();
    //Befor Tests get the page
    @BeforeTest
    public void GetWebsite()
    {
        driver.ChromeSetup();
        driver.GetPage();
    }

    //login with valid data
    @Test (priority = 0)
    public void  ValidLogin() {
        driver.UserNameLoc("username").sendKeys("tomsmith");
        driver.PasswordLoc("password").sendKeys("SuperSecretPassword!");
        driver.LoginButtonLoc("button[type=submit]").click();
        Soft.assertEquals(driver.GetCurrentUrl(), driver.SuccessUrl);
        Soft.assertAll();
    }
    //Get Success message Page
    @Test (priority = 1)
    public void SuccessPage()
    {
        Soft.assertTrue(driver.GetSuccesMsg("flash").contains("You logged into a secure area!"));
        Soft.assertEquals(driver.GetBackgroundColor("background-color"),"rgba(93, 164, 35, 1)");
        Soft.assertEquals(driver.GetBackgroundColor("color"),"rgba(255, 255, 255, 1)");
        Soft.assertTrue(driver.SubHeaderText().contains("Welcome to the Secure Area. When you are done click logout below."));
        Soft.assertTrue(driver.HeaderText().contains("Secure Area"));
        driver.GithubURl().click();
        Soft.assertEquals(driver.GetCurrentUrl(),driver.GithubUrl);
        driver.NavigateBack();
        Soft.assertAll();

    }
    //login with Invalid username
    @Test (priority = 2)
    public void  userNameInValidLogin()
    {
        driver.GetPage();
        driver.UserNameLoc("username").sendKeys("tomith");
        driver.PasswordLoc("password").sendKeys("SuperSecretPassword!");
        driver.LoginButtonLoc("button[type=submit]").click();
        Soft.assertEquals(driver.GetCurrentUrl(), "https://the-internet.herokuapp.com/login");
        Soft.assertTrue(driver.InvalidUserNameText().contains("Your username is invalid!"));
        Soft.assertEquals(driver.GetBackgroundColor("background-color"),"rgba(198, 15, 19, 1)");
        Soft.assertEquals(driver.GetBackgroundColor("color"),"rgba(255, 255, 255, 1)");
        Soft.assertAll();
    }

    //Login with Password
    @Test (priority = 3)
    public void PasswordInvalidLogin()
    {
        driver.GetPage();
        driver.UserNameLoc("username").sendKeys("tomsmith");
        driver.PasswordLoc("password").sendKeys("SuperPassword!");
        driver.LoginButtonLoc("button[type=submit]").click();
        Soft.assertEquals(driver.GetCurrentUrl(), "https://the-internet.herokuapp.com/login");
        Soft.assertTrue(driver.InvalidUserNameText().contains("Your password is invalid!"));
        Soft.assertEquals(driver.GetBackgroundColor("background-color"),"rgba(198, 15, 19, 1)");
        Soft.assertEquals(driver.GetBackgroundColor("color"),"rgba(255, 255, 255, 1)");
        Soft.assertAll();
    }
    @AfterTest
    public void CloseBrowser()
    {
        driver.Close();
    }
}
