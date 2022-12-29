package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    private final Logger log = LogManager.getLogger();

    @FindBy(xpath = "//*[@id=\"tds-site-header\"]/ol[1]/li[1]/a")
    private WebElement modelS;

    @FindBy(xpath = "//*[@id=\"tds-site-header\"]/ol[2]/li[1]/a")
    private WebElement shop;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPage open() {
        driver.navigate().to("https://www.tesla.com/");
        log.info("Main page is opened");
        return this;
    }

    public ModelSPage openModelSPage() {
        modelS.click();
        log.info("Model S page is opened");
        return new ModelSPage(driver);
    }

    public ShopPage openShopPage() {
        shop.click();
        log.info("Shop page is opened");
        return new ShopPage(driver);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}