package AmazonAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AmazonHomeWithTestControl {

    // this way we can test applications using TestNG features. Such as "@" methods

    WebDriver driver = null;

    // TestNG annotation of beforemethod, will run before executing the test cases
    @BeforeMethod
    public void setUp() {
        // path setup for chrome browser
        System.setProperty("webdriver.chrome.driver", "J:\\Intellij Projects\\SeleniumDemo\\driver\\chromedriver.exe");
        driver = new ChromeDriver();

        // implicit wait of 10 sec
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //go to amazon.com
        driver.get("https://www.amazon.com/");

        // maximizing the opening window by using selenium action class
        driver.manage().window().maximize();
    }

    // first test case uing testng annotation - @Test
    @Test
    public void test1() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Books" , Keys.ENTER);
        driver.findElement(By.id("twotabsearchtextbox")).clear();
    }

    // second test case
    @Test
    public void test2() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Honey" , Keys.ENTER);
        driver.findElement(By.id("twotabsearchtextbox")).clear();

        driver.findElement(By.id("nav-search-dropdown-card")).click();
    }

    // TestNG annotation of aftermethod, will run after completing all the test cases
    @AfterMethod
    public void cleanUp() {
        driver.close();
    }

}
