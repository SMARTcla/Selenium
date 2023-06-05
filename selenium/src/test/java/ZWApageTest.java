import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ZWApageTest {
    private WebDriver driver;
    private ZWApage homePage;
    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--whitelisted-ips=\"\"");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        homePage = new ZWApage(driver);
        PageFactory.initElements(driver, homePage);
        homePage.get();
        driver.manage().window().maximize();
    }

    public ZWApageTest() {
        driver = new ChromeDriver();
        homePage = new ZWApage(driver);
        PageFactory.initElements(driver, homePage);
    }
    @Test
    public void TestPage() {
        driver.get(homePage.getHomeUrl());
        driver.manage().window().maximize();
        homePage.clickmovies();
        homePage.clickpage();
        homePage.clickmovie();
        String cost = homePage.readcost();
        Assert.assertEquals(cost, "$100000000");

    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
