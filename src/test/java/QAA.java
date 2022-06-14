
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class QAA {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("http://localhost/%D0%9D%D0%BE%D0%B2%D0%B0%D1%8F%20%D0%BF%D0%B0%D0%BF%D0%BA%D0%B0/index.html");
        WebElement movieSeach = driver.findElement(By.id("film_name"));
        WebElement searchBtn = driver.findElement(By.id("get_api_res_btn"));
       movieSeach.sendKeys("Die Hard");
       searchBtn.click();
        String expectedDirector = "John McTiernan";
        String expectedYear = "1988";
        String expectedTitle = "Die Hard";
       WebElement directorName = new WebDriverWait(driver, Duration.ofSeconds(30)).until(elementToBeClickable(By.id("api_director")));
        System.out.println("Director's Name: " + directorName.getText().substring(10));
        Assert.assertEquals(directorName.getText().substring(10), expectedDirector);
        WebElement Yearofrelease = new WebDriverWait(driver, Duration.ofSeconds(30)).until(elementToBeClickable(By.id("api_year")));
        System.out.println("Year of release: " + Yearofrelease.getText().substring(6));
        Assert.assertEquals(Yearofrelease.getText().substring(6), expectedYear);
        WebElement Titlefilm = new WebDriverWait(driver, Duration.ofSeconds(30)).until(elementToBeClickable(By.id("api_title")));
        System.out.println("Title Film: " + Titlefilm.getText().substring(7));
        Assert.assertEquals(Titlefilm.getText().substring(7), expectedTitle);

    }
}
