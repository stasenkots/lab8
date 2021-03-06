import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SkyscannerHomePage {
    private WebDriver driver;
    private String HOMEPAGE_URL = "https://www.skyscanner.ru";

    @FindBy(xpath = "//*[@id='skhot']")
    private WebElement hotelButton;

    public SkyscannerHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SkyscannerHomePage openHomePage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        ).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='skhot']/span")));
        return this;
    }

    public SkyscannerHomePage openHotelPage(){
        hotelButton.click();
        return this;
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
}