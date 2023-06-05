import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZWApage {
    private WebDriver driver;
    private String url = "https://wa.toad.cz/~kononmi1";
    public ZWApage(WebDriver driver) {
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


    @FindBy(xpath = "/html/body/div[2]/div[2]/div/a[3]")
    private WebElement page;
    public void clickpage() {
        page.click();
    }

    @FindBy(xpath = "/html/body/div[2]/div[1]/ul[2]/li[2]/div/span/a")
    private WebElement movie;
    public void clickmovie() {
        movie.click();
    }


    @FindBy(xpath = "/html/body/section/div/table/tbody/tr[8]/td[2]")
    private WebElement cost;
    public String readcost() {
        return cost.getText();
    }

}
