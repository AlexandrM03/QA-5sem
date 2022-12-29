package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ModelSPage extends BasePage{
    private final Logger log = LogManager.getLogger();

    @FindBy(xpath = "//*[@id=\"tw-chat--avaya-chat__animated_button\"]")
    private WebElement chatButton;

    public ModelSPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isChatOpen() {
        wait.until(ExpectedConditions.elementToBeClickable(chatButton)).click();
        try {
            log.info("Checking if chat is open");
            WebElement chatWindow = driver.findElement(By.xpath("//*[@id=\"avaya-chat-modal\"]/header/div[2]/span[1]"));
            return chatWindow.isDisplayed();
        } catch (Exception e) {
            log.info("Chat is not open");
            return false;
        }
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
