package org.example.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResultPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ResultPage(WebDriver driver) {
        this.driver =driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getUrl()  {
        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1")));
        return driver.getCurrentUrl();
    }

    public ResultPage close() {
        driver.close();
        return this;
    }
}
