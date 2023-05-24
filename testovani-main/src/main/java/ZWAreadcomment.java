import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZWAreadcomment {
    private WebDriver driver;
    private String url = "https://wa.toad.cz/~kononmi1";
    public ZWAreadcomment(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void get() {
        driver.get(url);
    }
    public String getHomeUrl() {
        return url;
    }

    @FindBy(xpath = "/html/body/section/div/div[3]/a")
    private WebElement moviesPage;
    public void clickmoviesPage() {
        moviesPage.click();
    }
    @FindBy(xpath = "/html/body/section/div/h4[3]")
    private WebElement commenttext;
    public String readcommenttext() {
        return commenttext.getText();
    }

}
