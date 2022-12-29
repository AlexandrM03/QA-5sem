package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.ProductPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class CartTest extends CommonConditions {
    @Test
    public void isCartNotEmpty() {
        boolean isCartEmpty = new ProductPage(driver)
                .open()
                .addToCart()
                .goToCart()
                .isCartEmpty();
        Assert.assertFalse(isCartEmpty);
    }

    @Test
    public void removeCartEmpty() {
        boolean isCartEmpty = new ProductPage(driver)
                .open()
                .addToCart()
                .goToCart()
                .removeProduct()
                .isCartEmpty();
        assertThat("Cart is empty", isCartEmpty);
    }

    @Test
    public void isCartEmpty() {
        boolean isCartEmpty = new ProductPage(driver)
                .open()
                .goToCart()
                .isCartEmpty();
        assertThat("Cart is empty", isCartEmpty);
    }

    @Test
    public void cartPageOpened() {
        String cartUrl = new ProductPage(driver)
                .open()
                .goToCart()
                .getCartUrl();
        assertThat("Cart page opened", cartUrl.equals("https://shop.tesla.com/cart"));
    }

    @Test
    public void logoClickTest() {
        String url = new ProductPage(driver)
                .open()
                .goToMainPage()
                .getUrl();
        assertThat("Main page opened", url.equals("https://www.tesla.com/"));
    }
}
