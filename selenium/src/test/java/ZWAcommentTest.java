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

public class ZWAcommentTest {
    private WebDriver driver;
    private ZWAcomment homePage;
    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--whitelisted-ips=\"\"");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        homePage = new ZWAcomment(driver);
        PageFactory.initElements(driver, homePage);
        homePage.get();
        driver.manage().window().maximize();
    }

    public ZWAcommentTest() {
        driver = new ChromeDriver();
        homePage = new ZWAcomment(driver);
        PageFactory.initElements(driver, homePage);
    }
    @Test
    public void testLogin() {
        driver.get(homePage.getHomeUrl());
        driver.manage().window().maximize();
        WebElement loginpage = driver.findElement(By.xpath("//*[@id=\"navigation\"]/ul/li[5]/a/h1"));
        loginpage.click();
        WebElement enterlogin = driver.findElement(By.xpath("//*[@id=\"login\"]"));
        enterlogin.sendKeys("testing");
        WebElement enterpassword = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        enterpassword.sendKeys("Kxsj2xvaf");
        WebElement login = driver.findElement(By.xpath("//*[@id=\"login_form\"]/input"));
        login.click();
        WebElement home = driver.findElement(By.xpath("//*[@id=\"navigation\"]/ul/li[2]/a"));
        home.click();
        WebElement movies = driver.findElement(By.xpath("/html/body/header/div/nav/ul/li[3]/a"));
        movies.click();
        WebElement comedy = driver.findElement(By.xpath("/html/body/section/div/div[1]/a"));
        comedy.click();
        WebElement film = driver.findElement(By.xpath("/html/body/div[2]/div/ul[2]/li/div/span/a"));
        film.click();
        WebElement entercomment = driver.findElement(By.xpath("//*[@id=\"review_text\"]"));
        entercomment.sendKeys("Good film");
        WebElement entergrade = driver.findElement(By.xpath("//*[@id=\"review_grade\"]"));
        entergrade.sendKeys("10");
        WebElement clicks = driver.findElement(By.xpath("//*[@id=\"review_form\"]/input"));
        clicks.click();
//        WebElement comment = driver.findElement(By.xpath("//*[@id=\"login\"]"));
//        enterlogin.sendKeys("testing");
//        WebElement enterpassword = driver.findElement(By.xpath("//*[@id=\"password\"]"));
//        enterpassword.sendKeys("Kxsj2xvaf");
//        WebElement login = driver.findElement(By.xpath("//*[@id=\"login_form\"]/input"));
//        login.click();
//        WebElement logout = driver.findElement(By.xpath("//*[@id=\"navigation\"]/ul/li[5]/a"));
//        String logoutlink = logout.getText();
//        Assert.assertEquals(logoutlink, "Logout");

    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
