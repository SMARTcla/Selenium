import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZWAsearch {
    private WebDriver driver;
    private String url = "https://wa.toad.cz/~kononmi1";
    public ZWAsearch(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void get() {
        driver.get(url);
    }
    public String getHomeUrl() {
        return url;
    }
    @FindBy(xpath = "//*[@id=\"navigation\"]/ul/li[2]/a")
    private WebElement movies;
    public void clickmovies() {
        movies.click();
    }


    @FindBy(xpath = "/html/body/section/div/div[2]/a")
    private WebElement science;
    public void clickscience() {
        science.click();
    }

    @FindBy(xpath = "/html/body/div[2]/div/ul[1]/li[2]/div/span/a")
    private WebElement movie;
    public void clickmovie() {
        movie.click();
    }

    @FindBy(xpath = "/html/body/section/div/h2")
    private WebElement filmname;
    public String readfilmname() {
        return filmname.getText();
    }


}
