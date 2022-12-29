package page;

import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import service.UserFactory;

public class AuthPage extends BasePage {
    private final Logger log = LogManager.getLogger();

    @FindBy(id = "form-input-identity")
    private WebElement emailInput;
    @FindBy(id = "form-submit-continue")
    private WebElement continueButton;

    public AuthPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public AuthPage open() {
        driver.navigate().to("https://auth.tesla.com/oauth2/v1/authorize?redirect_uri=https%3A%2F%2Fwww.tesla.com%2Fteslaaccount%2Fowner-xp%2Fauth%2Fcallback&response_type=code&client_id=ownership&scope=offline_access%20openid%20ou_code%20email%20phone&audience=https%3A%2F%2Fownership.tesla.com%2F&locale=en-US");
        log.info("Auth page is opened");
        return this;
    }

    public User getUser() {
        return UserFactory.getUserInfo();
    }

    public AuthPage fillEmail() {
        wait.until(ExpectedConditions.elementToBeClickable(emailInput))
                .sendKeys(UserFactory.getUserInfo().getEmail());
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
        log.info("Email is filled");
        return this;
    }
}
