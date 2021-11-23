import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SkyscannerHotelButtonTest {
    private WebDriver driver;

    @BeforeTest (alwaysRun = true)
    public void browserSetup(){
        driver = new SafariDriver();
    }

    @Test
    public void goToTheHotelPage() throws InterruptedException {
        SkyscannerHomePage homePage = new SkyscannerHomePage(driver);
        homePage.openHomePage();
        homePage.openHotelPage();

        SkyscannerHotelPage hotelPage = new SkyscannerHotelPage(driver);
        hotelPage.openHotelPage();

        Assert.assertEquals(homePage.getCurrentUrl(), hotelPage.getCurrentUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }
}