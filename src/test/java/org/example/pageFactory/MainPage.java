package org.example.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;
private WebDriverWait wait;
    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public MainPage enterQuery(String query){
        WebElement queryField=driver.findElement(By.name("search"));
        queryField.clear();
        queryField.sendKeys(query);
        return this;
    }
    public MainPage findQuery(){
        WebElement findQueryButton= driver.findElement(By.xpath("//button[contains(@class,'button button_color_green button_size_medium search-form__submit ng-star-inserted')]"));
        findQueryButton.click();
        return this;
    }



}
