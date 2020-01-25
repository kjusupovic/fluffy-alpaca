import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class ProjektTestowy {

    private static final By ID_CENTER_COLUMN_P = By.xpath("//*[@id=\"center_column\"]/p");
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 15);
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void contactUs() {
        driver.findElement(By.id("contact-link")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("navigation_page")));
        WebElement contact = driver.findElement(By.className("navigation_page"));
        assertTrue(contact.getText().contains("Contact"));

    }


    @Test
    public void sendMessage() throws InterruptedException {
        driver.findElement(By.id("contact-link")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_contact")));

        Select subject = new Select(driver.findElement(By.id("id_contact")));

        subject.selectByIndex(2);

        driver.findElement(By.id("email")).sendKeys("test@test.pl");

        driver.findElement(By.id("message")).sendKeys("Testujemy wiadomość testową");

        driver.findElement(By.id("submitMessage")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(ID_CENTER_COLUMN_P));

        WebElement successAlert = driver.findElement(ID_CENTER_COLUMN_P);

        assertTrue(successAlert.getText().contains("Your message has been successfully sent to our team."));
    }

    @Test
    public void addToCart() throws InterruptedException {
        List<WebElement> addToCart = driver.findElements(By.className("ajax_add_to_cart_button"));

        addToCart.get(5).click();

        Thread.sleep(3000);
        WebElement productAdded = driver.findElement(By.className("layer_cart_product"));
        assertTrue(productAdded.getText().contains("Product successfully added to your shopping cart"));
    }

    @Test
    public void checkingBasket() throws InterruptedException {
        String productName = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[6]/div/div[2]/h5/a")).getText();

        List<WebElement> addToCart = driver.findElements(By.className("ajax_add_to_cart_button"));

        addToCart.get(3).click();

        Thread.sleep(3000);

        driver.findElement(By.className("cross")).click();
        Thread.sleep(3000);
        driver.findElement(By.className("shopping_cart")).click();
//        Thread.sleep(3000);
//      WebElement nameInCart = driver.findElement(By.className("product-name"));
//
//        assertTrue(nameInCart.getText().contains(productName));


    }

//
//    @After
//    public void turnDown(){
//        driver.quit();
//
//    }

}


