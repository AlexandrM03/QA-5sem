package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

public class ModelXPage extends BasePage {

    @FindBy(xpath = "/html/body/div[5]/div/div/header/ol[1]/li[3]/a")
    private WebElement modelXBtn;

    public ModelXPage(WebDriver driver) {
        super(driver);
    }

    public void toOrder() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                modelXBtn);
//        wait.until(ExpectedConditions.elementToBeClickable(modelXBtn)).click();
    }

    public boolean isLoaded() {
        return Objects.equals(driver.getCurrentUrl(), "https://www.tesla.com/modelx");
    }
}
