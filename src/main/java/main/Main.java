package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Main {

    static WebDriver driver;
    static WebElement getElement(By locator){
        return driver.findElement(locator);
    }
    static void typeIn (By locator, String input){
        getElement(locator).sendKeys(input);
    }

       static double expectedTotal () {
        WebElement article1 = driver.findElement(By.xpath("//table/tbody/tr[1]/td[6]/span[2]"));
        WebElement article2 = driver.findElement(By.xpath("//table/tbody/tr[2]/td[6]/span[2]"));

       double price1 = Double.parseDouble((article1.getText()));
       double price2 = Double.parseDouble((article2.getText()));
       Double expTotal = price1+price2;

       return expTotal;


    }


    public static void main(String[] args) {

        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        getElement(By.cssSelector(".picture a[title='Show details for 14.1-inch Laptop']")).click();
        getElement(By.id("add-to-cart-button-31")).click();
        getElement(By.cssSelector(".header-logo a")).click();
        getElement(By.cssSelector(".picture a[title='Show details for Build your own cheap computer']")).click();
        getElement(By.id("add-to-cart-button-72")).click();
        getElement(By.cssSelector("li[id='topcartlink'] a[href='/cart']")).click();

        String actualTotal = getElement(By.cssSelector(".total-info .order-total")).getText();
        double actTotal = Double.parseDouble(actualTotal);

        Assert.assertEquals(expectedTotal(), actTotal);

        driver.quit();






















    }





}
