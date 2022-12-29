package page;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() throws InterruptedException {
        return Objects.equals(driver.getCurrentUrl(), "https://www.tesla.com/");
    }
}

