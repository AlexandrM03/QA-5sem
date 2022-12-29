package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class ShopTest extends CommonConditions {
    @Test
    public void isShopOpen() {
        String shopUrl = new MainPage(driver)
                .open()
                .openShopPage()
                .getUrl();
        assertThat("Shop is open", shopUrl.equals("https://shop.tesla.com/"));
    }
}
