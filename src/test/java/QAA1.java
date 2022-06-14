import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.testng.Assert.assertEquals;

public class QAA1 {
    public static void main (String[] args){
        title();
        year();
        director();
    }
    static void director(){
        System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost/%D0%9D%D0%BE%D0%B2%D0%B0%D1%8F%20%D0%BF%D0%B0%D0%BF%D0%BA%D0%B0/index.html");
        String expectedDirector = "John McTiernan";

        WebElement movieSearch = driver.findElement(By.id("film_name"));
        WebElement searchBtn = driver.findElement(By.id("get_api_res_btn"));

        movieSearch.sendKeys("Die Hard");
        searchBtn.click();
        WebElement directorName = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(elementToBeClickable(By.id("api_director")));
        System.out.println("Director's Name:" + directorName.getText().substring(10));
        assertEquals(directorName.getText().substring(10), expectedDirector);
    }
    static void year(){
        System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost/%D0%9D%D0%BE%D0%B2%D0%B0%D1%8F%20%D0%BF%D0%B0%D0%BF%D0%BA%D0%B0/index.html");
        String expectedYear = "1988";
        WebElement movieSearch = driver.findElement(By.id("film_name"));
        WebElement searchBtn = driver.findElement(By.id("get_api_res_btn"));

        movieSearch.sendKeys("Die Hard");
        searchBtn.click();
        WebElement filmYear = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(elementToBeClickable(By.id("api_year")));
        System.out.println("Year:" + filmYear.getText().substring(6));
        Assert.assertEquals(filmYear.getText().substring(6), expectedYear);
    }
    static void title(){
        System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost/%D0%9D%D0%BE%D0%B2%D0%B0%D1%8F%20%D0%BF%D0%B0%D0%BF%D0%BA%D0%B0/index.html");
        String expectedTitle = "Hard";
        WebElement movieSearch = driver.findElement(By.id("film_name"));
        WebElement searchBtn = driver.findElement(By.id("get_api_res_btn"));

        movieSearch.sendKeys("Hard");
        searchBtn.click();
        WebElement filmTitle = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(elementToBeClickable(By.id("api_title")));
        System.out.println("Title:" + filmTitle.getText().substring(11));
        Assert.assertEquals(filmTitle.getText().substring(11), expectedTitle);
    }
}