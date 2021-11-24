import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import javax.annotation.CheckForNull;
import java.time.chrono.JapaneseChronology;

public class PageLoadedCondition implements ExpectedCondition<Boolean> {

    @Override
    public Boolean apply(WebDriver driver) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        return executor.executeScript("return document.readyState") == "complete";
    }
}
