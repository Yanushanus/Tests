package org.example.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CatalogPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CatalogPage(WebDriver driver) {
        this.driver =driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public CatalogPage pressOnCatalog(){
        WebElement button=driver.findElement(By.xpath("//a[contains(@class,'main-categories__link ng-star-inserted')]"));
        button.click();
        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@class,'menu-main__link button--medium button--link')]")));
        return this;
    }
    public CatalogPage goToProducts(){
        WebElement productCategory=driver.findElement(By.xpath("//a[contains(@class,'menu-main__link button--medium button--link')]"));
        productCategory.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1")));
        return this;
    }
    public String getUrl(){
        return driver.getCurrentUrl();
    }
    public CatalogPage close(){
        driver.close();
        return this;
    }
}
