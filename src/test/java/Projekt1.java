import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.*;
import static org.junit.Assert.assertTrue;

public class Projekt1 {
    String searchPhrase = "Selenium";
    WebDriver driver;

    @Before
    public void setUp (){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

       driver = new ChromeDriver();
       driver.get("http://automationpractice.com/index.php");
    }


//    @Test
//    public void googleSearchTest() {
//
//        driver.get("https://www.google.com");
//
//        WebElement searchInput = driver.findElement(By.name("q"));
//
//        searchInput.sendKeys(searchPhrase);
//        searchInput.sendKeys(Keys.ENTER);
//
//        WebElement firstResult = driver.findElements(By.className("g")).get(0);
//        System.out.println(firstResult.getText());
//        Assert.assertTrue(firstResult.getText().contains(searchPhrase));
//
//    }

    @Test
    public void automationPractice() throws InterruptedException {

//        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a")).click();
//        Thread.sleep(3000);
//        WebElement breadcrumbWomen =  driver.findElement(By.className("breadcrumb"));
//        assertTrue(breadcrumbWomen.getText().contains("Women"));
//
//        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
//        Thread.sleep(3000);
//        WebElement breadcrumbWomen =  driver.findElement(By.className("breadcrumb"));
//        assertTrue(breadcrumbWomen.getText().contains("Dresses"));
        assertTab(1, "Women");
        assertTab(2, "Dresses");
        assertTab(3, "T-shirts");

    }

    @After
    public void turnDown(){
        driver.quit();
    }

    private void assertTab(int index, String value) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[" + index + "]/a")).click();
        Thread.sleep(3000);
        WebElement breadcrumb =  driver.findElement(By.className("breadcrumb"));
        assertTrue(breadcrumb.getText().contains(value));

    }

}
