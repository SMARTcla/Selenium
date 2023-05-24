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

public class ZWAloginTest {
    private WebDriver driver;
    private ZWAlogin homePage;
    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--whitelisted-ips=\"\"");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        homePage = new ZWAlogin(driver);
        PageFactory.initElements(driver, homePage);
        homePage.get();
        driver.manage().window().maximize();
    }

    public ZWAloginTest() {
        driver = new ChromeDriver();
        homePage = new ZWAlogin(driver);
        PageFactory.initElements(driver, homePage);
    }
    @Test
    public void testLogin() {
        driver.get(homePage.getHomeUrl());
        driver.manage().window().maximize();
        homePage.clickloginpage();
        homePage.clickenterlogin("testing");
        homePage.clickenterpassword("Kxsj2xvaf");
        homePage.clicklogininto();
        String logout = homePage.readlogout();
        Assert.assertEquals(logout, "Logout");

    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
