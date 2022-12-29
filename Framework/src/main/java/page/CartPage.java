package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {
    private final Logger log = LogManager.getLogger();

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage removeProduct() {
        log.info("Removing product from cart");
        try {
            WebElement removeButton = driver.findElement(By.xpath("//a[text()='Remove']"));
            log.info("Remove button found");
            wait.until(ExpectedConditions.elementToBeClickable(removeButton)).click();
            WebElement confirmRemoveButton = driver.findElement(By.xpath("//button[text()='Yes, Remove']"));
            log.info("Confirm remove button found");
            wait.until(ExpectedConditions.elementToBeClickable(confirmRemoveButton)).click();
        } catch (Exception e) {
            log.error("Product not found in cart");
        }
        return this;
    }

    public boolean isCartEmpty() {
        log.info("Checking if cart is empty");
        try {
            WebElement emptyCart = driver.findElement(By.xpath("//*[@id=\"cart\"]/div/div[2]/div[1]/p"));
            return emptyCart.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getCartUrl() {
        return driver.getCurrentUrl();
    }
}
