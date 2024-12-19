package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) throws InterruptedException {
        WebDriver objDriver = new ChromeDriver();

        objDriver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");
        objDriver.manage().window().maximize();

        objDriver.findElement(By.id("input-firstname")).sendKeys("Alejandrosadsaddsadsaasdqwewqrwrweqf");
        objDriver.findElement(By.id("input-lastname")).sendKeys("Rimasa");
        objDriver.findElement(By.id("input-email")).sendKeys("aleRima0010@gmail.com");
        objDriver.findElement(By.id("input-telephone")).sendKeys("1234567890");
        objDriver.findElement(By.id("input-password")).sendKeys("Password123");
        objDriver.findElement(By.id("input-confirm")).sendKeys("Password123");

        WebElement termsCheckbox = objDriver.findElement(By.xpath("//label[@for='input-agree']"));
        termsCheckbox.click();

        WebElement continueButton = objDriver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();

        WebElement successMessage = objDriver.findElement(By.xpath("//h1[contains(text(), 'Tu cuenta fue creada exitosamente!')]"));
        System.out.println("Mensaje de éxito: " + successMessage.getText());

        objDriver.quit();
    }
}


