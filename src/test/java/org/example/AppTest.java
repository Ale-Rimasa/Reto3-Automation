package org.example;
import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest extends TestCase {
    public void testRegistrationForm() throws InterruptedException {
        WebDriver objDriver = new ChromeDriver();
            objDriver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");
            objDriver.manage().window().maximize();

            objDriver.findElement(By.id("input-firstname")).sendKeys("Alejandro");
            Thread.sleep(1000L);
            objDriver.findElement(By.id("input-lastname")).sendKeys("Rimasa");
            Thread.sleep(1000L);
            objDriver.findElement(By.id("input-email")).sendKeys("aleRima0050@gmail.com");
            Thread.sleep(1000L);
            objDriver.findElement(By.id("input-telephone")).sendKeys("1244767290");
            Thread.sleep(1000L);
            objDriver.findElement(By.id("input-password")).sendKeys("Password123");
            Thread.sleep(1000L);
            objDriver.findElement(By.id("input-confirm")).sendKeys("Password123");

            WebElement SuscripcionCheckbox = objDriver.findElement(By.xpath("//label[@for='input-agree']"));
            SuscripcionCheckbox.click();
            Thread.sleep(1000L);
            WebElement continueButton = objDriver.findElement(By.xpath("//input[@value='Continue']"));
            continueButton.click();
            Thread.sleep(1000L);
            WebElement successMessage = objDriver.findElement(By.xpath("//h1[contains(text(), 'Your Account Has Been Created!')]"));
            System.out.println("Mensaje de éxito: " + successMessage.getText());

            assertEquals("Your Account Has Been Created!", successMessage.getText());
            objDriver.quit();

    }
}
