import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SkyscannerHotelButtonTest {
    private WebDriver driver;

    @Before()
    public void browserSetup() {
//        System.setProperty("webdriver.chrome.driver", "/usr/lib/chromium-browser/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }

    @Test
    public void goToTheHotelPage() throws InterruptedException {
        SkyscannerHomePage homePage = new SkyscannerHomePage(driver);
        homePage.openHomePage();

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='skhot']/span")));
        homePage.openHotelPage();

        SkyscannerHotelPage hotelPage = new SkyscannerHotelPage(driver);
        hotelPage.openHotelPage();

        Assert.assertEquals(homePage.getCurrentUrl(), hotelPage.getCurrentUrl());
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}