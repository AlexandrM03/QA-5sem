package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
    private final Logger log = LogManager.getLogger();
    @FindBy(xpath = "//*[@id=\"page--product-details\"]/main/div/div/section[1]/div[1]/div[2]/div/div[2]/section/div[1]/input[1]")
    private WebElement addToCartButton;
    @FindBy(xpath = "//*[@id=\"tds-site-header\"]/div[2]/ol/div[2]/a")
    private WebElement cartButton;
    @FindBy(xpath = "//*[@id=\"left-menu__logo\"]/a[1]")
    private WebElement mainPageButton;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public ProductPage addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        log.info("Add to cart button clicked");
        return this;
    }

    public CartPage goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartButton)).click();
        log.info("Cart button clicked");
        return new CartPage(driver);
    }

    public MainPage goToMainPage() {
        wait.until(ExpectedConditions.elementToBeClickable(mainPageButton)).click();
        log.info("Back button clicked");
        return new MainPage(driver);
    }

    public ProductPage open() {
        driver.get("https://shop.tesla.com/product/sae-j1772-charging-adapter?sku=1067348-00-C");
        log.info("Product page opened");
        return this;
    }
}

