import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ZWAcsvTest {
    private WebDriver driver;
    private ZWAcsv homePage;
    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--whitelisted-ips=\"\"");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        homePage = new ZWAcsv(driver);
        PageFactory.initElements(driver, homePage);
        homePage.get();
        driver.manage().window().maximize();
    }

    public ZWAcsvTest() {
        driver = new ChromeDriver();
        homePage = new ZWAcsv(driver);
        PageFactory.initElements(driver, homePage);
    }
    @Test
    public void testLogin() {
        driver.get(homePage.getHomeUrl());
        driver.manage().window().maximize();
        String username = "";
        String password = "";
        String data = " ";
        String line = "";
        String splitBy = ",";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\misha\\Desktop\\testovani-main\\src\\test\\java\\login.csv"));
            while ((line = br.readLine()) != null)
            {
                String[] dataprov = line.split(splitBy);
                username = dataprov[0];
                password = dataprov[1];
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        WebElement loginpage = driver.findElement(By.xpath("//*[@id=\"navigation\"]/ul/li[5]/a/h1"));
        loginpage.click();
        WebElement enterlogin = driver.findElement(By.xpath("//*[@id=\"login\"]"));
        enterlogin.sendKeys("testing");//problem
        WebElement enterpassword = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        enterpassword.sendKeys(password);
        WebElement login = driver.findElement(By.xpath("//*[@id=\"login_form\"]/input"));
        login.click();
        WebElement logout = driver.findElement(By.xpath("//*[@id=\"navigation\"]/ul/li[5]/a"));
        String logoutlink = logout.getText();
        Assert.assertEquals(logoutlink, "Logout");

    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
