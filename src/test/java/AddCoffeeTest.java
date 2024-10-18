import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddCoffeeTest {
    WebDriver driver;

    @BeforeTest
    public void setTest() {
        System.setProperty("web.driver.geckodriver", "./drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://coffee-cart.app/");
    }

    @Test
    public void addExpresso() {
        WebElement expreso = driver.findElement(By.xpath("//div[2]/ul/li[1]"));
        expreso.click();
        WebElement totalElement = driver.findElement(By.className("pay"));
        String total = totalElement.getText().replace("Total:", " ").trim();
        Assert.assertEquals(total, "$10.00", "Total is not equal");
    }

    @Test
    public void addExpressoMacchiato() {
        WebElement expressoMacchiato = driver.findElement(By.xpath("//div[2]/ul/li[2]"));
        expressoMacchiato.click();
        WebElement totalElement = driver.findElement(By.className("pay"));
        String total = totalElement.getText().replace("Total:", " ").trim();
        Assert.assertEquals(total, "$22.00", "Total is not equal");
    }

    /* 

    @Test
    public void addCappucino() {
        WebElement cappucino = driver.findElement(By.xpath("//div[2]/ul/li[3]"));
        cappucino.click();
        WebElement totalElement = driver.findElement(By.className("pay"));
        String total = totalElement.getText().replace("Total:", " ").trim();
        Assert.assertEquals(total, "$41.00", "Total is not equal");
    }

    @Test
    public void getExtraCup() {
        if(driver.getPageSource().contains("It's your lucky day! Get an extra cup of Mocha for $4.")) {
            WebElement acceptButton = driver.findElement(By.className("yes"));
            acceptButton.click();
            WebElement totalElement = driver.findElement(By.className("pay"));
            String total = totalElement.getText().replace("Total:", " ").trim();
            Assert.assertEquals(total, "$45.00", "Total is not equal");
        }
    } 
    
    */

    @AfterTest
    public void exitBrowser() {
        driver.quit();
    }
}