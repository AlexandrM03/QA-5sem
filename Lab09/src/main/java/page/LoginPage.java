package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

public class LoginPage extends BasePage {

    @FindBy(css = "#tds-site-header > ol.tds-site-nav-items.tds-align--end.tds--product-name > li:nth-child(2) > a")
    private WebElement accountBtn;

    @FindBy(id = "form-input-identity")
    private WebElement loginInput;

    @FindBy(id = "form-submit-continue")
    private WebElement continueBtn;

    @FindBy(id = "form-input-credential")
    private WebElement passwordInput;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public boolean isLoaded() throws InterruptedException {
        Thread.sleep(5000);
        return Objects.equals(driver.getCurrentUrl(), "https://www.tesla.com/teslaaccount");
    }

    public void login(String login, String password) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(accountBtn));
        actions.moveToElement(accountBtn).click().perform();
        wait.until(ExpectedConditions.elementToBeClickable(loginInput));
        Thread.sleep(5000);
        actions.moveToElement(loginInput).sendKeys(login).perform();
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        actions.moveToElement(continueBtn).click().perform();
        wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        actions.moveToElement(passwordInput).sendKeys(password).perform();
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        actions.moveToElement(continueBtn).click().perform();
        Thread.sleep(5000);
    }
}
