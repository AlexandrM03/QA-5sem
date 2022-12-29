package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class QuestionCenterTest extends CommonConditions {
    @Test
    public void isChatOpen() {
        boolean isChatOpen = new MainPage(driver)
                .open()
                .openModelSPage()
                .isChatOpen();
        assertThat("Chat is open", isChatOpen);
    }
}
