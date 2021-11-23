import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkyscannerHomePage {
    private WebDriver driver;
    private String HOMEPAGE_URL = "https://www.skyscanner.ru";

    @FindBy(xpath = "//*[@id='skhot']/span")
    private WebElement hotelButton;

    public SkyscannerHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SkyscannerHomePage openHomePage() {
        driver.get(HOMEPAGE_URL);
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