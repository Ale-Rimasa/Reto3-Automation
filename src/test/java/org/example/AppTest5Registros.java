package org.example;

import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest5Registros extends TestCase {
    public void testMultipleRegistrations() throws InterruptedException {

        String[][] registros = {
                {"Alejandro", "Rimasa", "aleRima0200@gmail.com", "1144767290", "Password123"},
                {"Beatriz", "Mendoza", "beatrizM0201@gmail.com", "1176543210", "Password123"},
                {"Carlos", "Pérez", "carlosP0202@gmail.com", "1131231234", "Password123"},
                {"Diana", "López", "dianaL00203@gmail.com", "1164664267", "Password123"},
                {"Elena", "Gómez", "elenaG00204@gmail.com", "1157847890", "Password123"}
        };

        for (String[] registro : registros) {
            WebDriver objDriver = new ChromeDriver();

                objDriver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");
                objDriver.manage().window().maximize();

                objDriver.findElement(By.id("input-firstname")).sendKeys(registro[0]);
                Thread.sleep(1000L);
                objDriver.findElement(By.id("input-lastname")).sendKeys(registro[1]);
                Thread.sleep(1000L);
                objDriver.findElement(By.id("input-email")).sendKeys(registro[2]);
                Thread.sleep(1000L);
                objDriver.findElement(By.id("input-telephone")).sendKeys(registro[3]);
                Thread.sleep(1000L);
                objDriver.findElement(By.id("input-password")).sendKeys(registro[4]);
                Thread.sleep(1000L);
                objDriver.findElement(By.id("input-confirm")).sendKeys(registro[4]);
                Thread.sleep(1000L);

                WebElement SuscripcionCheckbox = objDriver.findElement(By.xpath("//label[@for='input-agree']"));
                SuscripcionCheckbox.click();
                Thread.sleep(1000L);

                WebElement continueButton = objDriver.findElement(By.xpath("//input[@value='Continue']"));
                continueButton.click();
                Thread.sleep(1000L);

                WebElement successMessage = objDriver.findElement(By.xpath("//h1[contains(text(), 'Your Account Has Been Created!')]"));
                System.out.println("Registro exitoso para: " + registro[2] + " - Mensaje: " + successMessage.getText());

                assertEquals("Your Account Has Been Created!", successMessage.getText());

                objDriver.quit();

        }
    }
}
