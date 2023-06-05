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

public class ZWAcompanyTest {
    private WebDriver driver;
    private ZWAdoc homePage;
    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--whitelisted-ips=\"\"");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        homePage = new ZWAdoc(driver);
        PageFactory.initElements(driver, homePage);
        homePage.get();
        driver.manage().window().maximize();
    }

    public ZWAcompanyTest() {
        driver = new ChromeDriver();
        homePage = new ZWAdoc(driver);
        PageFactory.initElements(driver, homePage);
    }
    @Test
    public void testGoogle() {
        driver.get(homePage.getHomeUrl());
        driver.manage().window().maximize();
        WebElement mainpage = driver.findElement(By.xpath("/html/body/footer/nav[2]/ul/li[2]/h3"));
        mainpage.click();
        WebElement career = driver.findElement(By.xpath("/html/body/div/div[1]/span"));
        String careerText = career.getText();
        Assert.assertEquals(careerText, "Google");
    }
    @Test
    public void testAmazon() {
        driver.get(homePage.getHomeUrl());
        driver.manage().window().maximize();
        WebElement mainpage = driver.findElement(By.xpath("/html/body/footer/nav[2]/ul/li[2]/h3"));
        mainpage.click();
        WebElement career = driver.findElement(By.xpath("/html/body/div/div[2]/span"));
        String careerText = career.getText();
        Assert.assertEquals(careerText, "Amazon");
    }
    @Test
    public void testMeta() {
        driver.get(homePage.getHomeUrl());
        driver.manage().window().maximize();
        WebElement mainpage = driver.findElement(By.xpath("/html/body/footer/nav[2]/ul/li[2]/h3"));
        mainpage.click();
        WebElement career = driver.findElement(By.xpath("/html/body/div/div[3]/span"));
        String careerText = career.getText();
        Assert.assertEquals(careerText, "Meta");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
