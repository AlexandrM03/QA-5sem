package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class ModelSTest extends CommonConditions {
    @Test
    public void isModelSPageOpened() {
        String url = new MainPage(driver)
                .open()
                .openModelSPage()
                .getUrl();
        assertThat("Url matched", url.equals("https://www.tesla.com/models"));
    }
}
