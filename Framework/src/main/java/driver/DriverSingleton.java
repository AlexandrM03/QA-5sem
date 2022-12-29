package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class DriverSingleton {
    private static final String SELENOID_URI = "http://" + System.getProperty("ip") + ":4444/wd/hub";
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    private DriverSingleton() {
    }

    public static WebDriver getDriver() throws MalformedURLException {
        if (webDriver.get() == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            if ("firefox".equals(System.getProperty("browser"))) {
                capabilities.setCapability("browserName", "firefox");
                capabilities.setCapability("browserVersion", "106.0");
            } else {
                capabilities.setCapability("browserName", "chrome");
                capabilities.setCapability("browserVersion", "107.0");
            }
            Map<String, Object> options = new HashMap<>();
            options.put("enableVNC", true);
            options.put("enableVideo", true);
            capabilities.setCapability("selenoid:options", options);
            webDriver.set(new RemoteWebDriver(URI.create(SELENOID_URI).toURL(), capabilities));
            webDriver.get().manage().window().maximize();
        }
        return webDriver.get();
    }

    public static void closeDriver() {
        if (webDriver.get() != null) {
            webDriver.get().quit();
            webDriver.set(null);
        }
    }
}