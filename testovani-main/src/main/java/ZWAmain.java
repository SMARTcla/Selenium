import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZWAmain {
    private WebDriver driver;
    private String url = "https://wa.toad.cz/~kononmi1";
    public ZWAmain(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void get() {
        driver.get(url);
    }
    public String getHomeUrl() {
        return url;
    }
    @FindBy(xpath = "/html/body/footer/nav[2]/ul/li[1]/h3")
    private WebElement mainpage;
    public void clickmainpage() {
        mainpage.click();
    }


    @FindBy(xpath = "/html/body/div/div[2]/h2")
    private WebElement work;
    public String readwork() {
        return work.getText();
    }

}
