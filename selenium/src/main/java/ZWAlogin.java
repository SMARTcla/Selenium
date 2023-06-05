import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZWAlogin {
    private WebDriver driver;
    private String url = "https://wa.toad.cz/~kononmi1";
    public ZWAlogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void get() {
        driver.get(url);
    }
    public String getHomeUrl() {
        return url;
    }
    @FindBy(xpath = "//*[@id=\"navigation\"]/ul/li[5]/a/h1")
    private WebElement loginpage;
    public void clickloginpage() {
        loginpage.click();
    }


    @FindBy(xpath = "//*[@id=\"login\"]")
    private WebElement enterlogin;
    public void clickenterlogin(String name) {
        enterlogin.sendKeys(name);;
    }


    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement enterpassword;
    public void clickenterpassword(String password) {
        enterpassword.sendKeys(password);;
    }


    @FindBy(xpath = "//*[@id=\"login_form\"]/input")
    private WebElement logininto;
    public void clicklogininto() {
        logininto.click();
    }



    @FindBy(xpath = "//*[@id=\"navigation\"]/ul/li[5]/a")
    private WebElement logout;
    public String readlogout() {
        return logout.getText();
    }

}
