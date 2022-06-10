
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
       movieSeach.sendKeys("Titanic");
       searchBtn.click();
        String expectedDirector = "James Cameron";
        String expectedYear = "1997";
       WebElement directorName = new WebDriverWait(driver, Duration.ofSeconds(30)).until(elementToBeClickable(By.id("api_director")));
        System.out.println("Director's Name: " + directorName.getText().substring(10));
        Assert.assertEquals(directorName.getText().substring(10), expectedDirector);
        WebElement Yearofrelease = new WebDriverWait(driver, Duration.ofSeconds(25)).until(elementToBeClickable(By.id("api_year")));
        System.out.println("Year of release: " + Yearofrelease.getText().substring(5));
        Assert.assertEquals(Yearofrelease.getText().substring(5), expectedYear);

    }
}
