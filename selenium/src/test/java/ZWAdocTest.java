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

public class ZWAdocTest {
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

    public ZWAdocTest() {
        driver = new ChromeDriver();
        homePage = new ZWAdoc(driver);
        PageFactory.initElements(driver, homePage);
    }
    @Test
    public void testManual() {
        driver.get(homePage.getHomeUrl());
        driver.manage().window().maximize();
        WebElement mainpage = driver.findElement(By.xpath("/html/body/footer/nav[2]/ul/li[5]/h3/a"));
        mainpage.click();
        WebElement career = driver.findElement(By.xpath("/html/body/div/div[2]/span"));
        String careerText = career.getText();
        Assert.assertEquals(careerText, "Manual");
    }

    @Test
    public void testDesc() {
        driver.get(homePage.getHomeUrl());
        driver.manage().window().maximize();
        WebElement mainpage = driver.findElement(By.xpath("/html/body/footer/nav[2]/ul/li[5]/h3/a"));
        mainpage.click();
        WebElement career = driver.findElement(By.xpath("/html/body/div/div[1]/span"));
        String careerText = career.getText();
        Assert.assertEquals(careerText, "Description");
    }
    @Test
    public void testDox() {
        driver.get(homePage.getHomeUrl());
        driver.manage().window().maximize();
        WebElement mainpage = driver.findElement(By.xpath("/html/body/footer/nav[2]/ul/li[5]/h3/a"));
        mainpage.click();
        WebElement career = driver.findElement(By.xpath("/html/body/div/div[3]/span"));
        String careerText = career.getText();
        Assert.assertEquals(careerText, "Doxygen");
    }
    @Test
    public void career() {
        driver.get(homePage.getHomeUrl());
        driver.manage().window().maximize();
        WebElement mainpage = driver.findElement(By.xpath("/html/body/footer/nav[2]/ul/li[5]/h3/a"));
        mainpage.click();
        WebElement career = driver.findElement(By.xpath("/html/body/footer/nav[2]/ul/li[1]/h3"));
        String careerText = career.getText();
        Assert.assertEquals(careerText, "Career");
    }
    @Test
    public void company() {
        driver.get(homePage.getHomeUrl());
        driver.manage().window().maximize();
        WebElement mainpage = driver.findElement(By.xpath("/html/body/footer/nav[2]/ul/li[5]/h3/a"));
        mainpage.click();
        WebElement career = driver.findElement(By.xpath("/html/body/footer/nav[2]/ul/li[2]/h3/a"));
        String careerText = career.getText();
        Assert.assertEquals(careerText, "Company");
    }
    @Test
    public void privat() {
        driver.get(homePage.getHomeUrl());
        driver.manage().window().maximize();
        WebElement mainpage = driver.findElement(By.xpath("/html/body/footer/nav[2]/ul/li[5]/h3/a"));
        mainpage.click();
        WebElement career = driver.findElement(By.xpath("/html/body/footer/nav[2]/ul/li[3]/h3"));
        String careerText = career.getText();
        Assert.assertEquals(careerText, "Privat Policy");
    }
    @Test
    public void terms() {
        driver.get(homePage.getHomeUrl());
        driver.manage().window().maximize();
        WebElement mainpage = driver.findElement(By.xpath("/html/body/footer/nav[2]/ul/li[5]/h3/a"));
        mainpage.click();
        WebElement career = driver.findElement(By.xpath("/html/body/footer/nav[2]/ul/li[4]/h3"));
        String careerText = career.getText();
        Assert.assertEquals(careerText, "Terms of Use");
    }
    @Test
    public void Documents() {
        driver.get(homePage.getHomeUrl());
        driver.manage().window().maximize();
        WebElement mainpage = driver.findElement(By.xpath("/html/body/footer/nav[2]/ul/li[5]/h3/a"));
        mainpage.click();
        WebElement career = driver.findElement(By.xpath("/html/body/footer/nav[2]/ul/li[5]/h3"));
        String careerText = career.getText();
        Assert.assertEquals(careerText, "Documents");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
