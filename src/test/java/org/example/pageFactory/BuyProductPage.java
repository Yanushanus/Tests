package org.example.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuyProductPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public BuyProductPage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public BuyProductPage click(){
        WebElement clicker=driver.findElement(By.xpath("//button[contains(@class,'buy-button goods-tile__buy-button ng-star-inserted')]"));
        clicker.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return this;
    }
    public BuyProductPage goToCart(){

        WebElement cartButton=driver.findElement(By.xpath("//button[contains(@class,'header__button ng-star-inserted header__button--active')]"));
        cartButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(@class,'cart-page__heading')]")));
        return this;
    }
    public String getUrl(){
        return driver.getCurrentUrl();
    }
    public BuyProductPage close(){
        driver.close();
        return this;
    }
}
