package org.example;

import org.example.pageFactory.BuyProductPage;
import org.example.pageFactory.CatalogPage;
import org.example.pageFactory.MainPage;
import org.example.pageFactory.ResultPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


public class AppTest {
    WebDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromeSource\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/ua/");
    }

    @Test
    public void checkResult() {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        String query = "dell";
        mainPage.enterQuery(query);
        mainPage.findQuery();
        ResultPage resultPage = PageFactory.initElements(driver, ResultPage.class);
        String expected = "https://rozetka.com.ua/ua/search/?text=dell&producer=dell&page=1";
        String actual = resultPage.getUrl();
        resultPage.close();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testingCart() throws InterruptedException {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        String query = "dell";
        mainPage.enterQuery(query);
        mainPage.findQuery();
        Thread.sleep(2000);
        BuyProductPage buyProductPage = PageFactory.initElements(driver, BuyProductPage.class);
        buyProductPage.click().goToCart();
        String expected = "https://rozetka.com.ua/ua/cart/";
        String actual = buyProductPage.getUrl();
        buyProductPage.close();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testingCatalog() {
        CatalogPage catalogPage = PageFactory.initElements(driver, CatalogPage.class);
        catalogPage.pressOnCatalog().goToProducts();
        String actual = catalogPage.getUrl();
        String expected = "https://rozetka.com.ua/ua/notebooks/c80004/";
        catalogPage.close();
        Assertions.assertEquals(expected, actual);
    }
}
