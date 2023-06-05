import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZWAcomment {
    private WebDriver driver;
    private String url = "https://wa.toad.cz/~kononmi1";
    public ZWAcomment(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void get() {
        driver.get(url);
    }
    public String getHomeUrl() {
        return url;
    }
    @FindBy(xpath = "//*[@class=\"product-explore-heading\"]")
    private WebElement loginHomeButton;
    public void clickLoginHomeButton() {
        loginHomeButton.click();
    }

}
