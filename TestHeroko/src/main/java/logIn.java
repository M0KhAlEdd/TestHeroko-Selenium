import com.sun.jna.WString;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class logIn {
    WebDriver Driver;
    String SuccessUrl ="https://the-internet.herokuapp.com/secure";
    String GithubUrl="https://github.com/saucelabs/the-internet";
    //Setup the chrome driver
    public void ChromeSetup()
    {
        WebDriverManager.chromedriver().setup();
        this.Driver= new ChromeDriver();
    }

    // Get page
    public void GetPage()
    {
        Driver.get("https://the-internet.herokuapp.com/login");
    }

    // the User Name Locator
    public WebElement UserNameLoc(String usernameId)
    {
        return Driver.findElement(By.id(usernameId));
    }
    // the Password  Locator
    public WebElement PasswordLoc(String PasswordId)
    {
        return Driver.findElement(By.id(PasswordId));
    }
    // the Login button Locator
    public WebElement LoginButtonLoc(String ButtoonCss)
    {
        return Driver.findElement(By.cssSelector(ButtoonCss));
    }

    //Get Current URL
    public String GetCurrentUrl()
    {
        return Driver.getCurrentUrl();
    }

    //Get SuccessMsg
    public String GetSuccesMsg(String MsgId)
    {
    return Driver.findElement(By.id(MsgId)).getText();
    }
    //get webelmenet Github
    public WebElement GithubURl()
    {
        return Driver.findElement(By.cssSelector("img[alt=\"Fork me on GitHub\"]"));
    }
    //Navigate Back
    public void NavigateBack()
    {
        Driver.navigate().back();
    }
    //Subheader text color
    public String SubHeaderText()
    {
        return Driver.findElement(By.className("subheader")).getText();
    }
    //Header text

    public String HeaderText()
    {
        return Driver.findElement(By.tagName("h2")).getText();
    }
    //BackGround color
    public String GetBackgroundColor(String color)
    {
        return Driver.findElement(By.id("flash")).getCssValue(color);
    }

    //Invalid username Get Text
    public String InvalidUserNameText()
    {
        return Driver.findElement(By.id("flash")).getText();
    }
    //Close
    public void Close()
    {
        Driver.quit();
    }
}
