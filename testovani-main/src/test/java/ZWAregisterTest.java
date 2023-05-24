import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class ZWAregisterTest {
    private WebDriver driver;
    private ZWAregister homePage;
    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--whitelisted-ips=\"\"");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        homePage = new ZWAregister(driver);
        PageFactory.initElements(driver, homePage);
        homePage.get();
        driver.manage().window().maximize();
    }

    public ZWAregisterTest() {
        driver = new ChromeDriver();
        homePage = new ZWAregister(driver);
        PageFactory.initElements(driver, homePage);
    }
    @Test
    public void testRegisterError() {
        driver.get(homePage.getHomeUrl());
        driver.manage().window().maximize();
        homePage.clickregisterpage();
        homePage.clickenterlogin("testss");
        homePage.clickenterfirstname("Mike");
        homePage.clickenteremail("kononmi1@cvut.cz");
        homePage.clickenterpassword("JDxadaws12");
        homePage.clickentercpassword("JDxadaws12");
        homePage.clickregisterclicks();
        String careerText = homePage.readerror();
        Assert.assertEquals(careerText, "This email already have had in database, choose other!");

    }

    @Test
    public void testRegisterSuccessfull() {
        driver.get(homePage.getHomeUrl());
        driver.manage().window().maximize();
        homePage.clickregisterpage();
        homePage.clickenterlogin("zsxazwnmn");
        homePage.clickenterfirstname("Mike");
        homePage.clickenteremail("konodfkzx1@cvut.cz");
        homePage.clickenterpassword("JDxaxas12");
        homePage.clickentercpassword("JDxaxas12");
        homePage.clickregisterclicks();
        String logined = homePage.readlogined();
        Assert.assertEquals(logined, "Logout");

    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
