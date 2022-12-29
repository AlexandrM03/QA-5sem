import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.HomePage;
import page.ModelXPage;

public class TestPage {
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = getDriver();
    }

    @Test
    public void isHomepageOpen() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        Assertions.assertTrue(homePage.isLoaded());
    }

    @Test
    public void isOrderOpen() {
        ModelXPage orderPage = new ModelXPage(driver);
        orderPage.open();
        orderPage.toOrder();
        Assertions.assertTrue(orderPage.isLoaded());
    }

    private WebDriver getDriver() {
        final ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        return new ChromeDriver(options);
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }
}
