import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZWAregister {
    private WebDriver driver;
    private String url = "https://wa.toad.cz/~kononmi1";
    public ZWAregister(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void get() {
        driver.get(url);
    }
    public String getHomeUrl() {
        return url;
    }
    @FindBy(xpath = "//*[@id=\"navigation\"]/ul/li[4]/a")
    private WebElement registerpage;
    public void clickregisterpage() {
        registerpage.click();
    }


    @FindBy(xpath = "//*[@id=\"login\"]")
    private WebElement enterlogin;
    public void clickenterlogin(String login) {
        enterlogin.sendKeys(login);;
    }

    @FindBy(xpath = "//*[@id=\"firstname\"]")
    private WebElement enterfirstname;
    public void clickenterfirstname(String firstname) {
        enterfirstname.sendKeys(firstname);;
    }


    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement enteremail;
    public void clickenteremail(String email) {
        enteremail.sendKeys(email);;
    }


    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement enterpassword;
    public void clickenterpassword(String password) {
        enterpassword.sendKeys(password);;
    }

    @FindBy(xpath = "//*[@id=\"cpassword\"]")
    private WebElement entercpassword;
    public void clickentercpassword(String cpassword) {
        entercpassword.sendKeys(cpassword);;
    }




    @FindBy(xpath = "//*[@id=\"register_form\"]/input")
    private WebElement registerclicks;
    public void clickregisterclicks() {
        registerclicks.click();
    }


    @FindBy(xpath = "/html/body/section/div/form/div[1]/p")
    private WebElement error;
    public String readerror() {
        return error.getText();
    }


    @FindBy(xpath = "//*[@id=\"navigation\"]/ul/li[5]/a")
    private WebElement logined;
    public String readlogined() {
        return logined.getText();
    }

}
