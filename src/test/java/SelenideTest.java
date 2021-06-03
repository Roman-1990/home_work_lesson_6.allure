import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class SelenideTest {

    private WebPage page = new WebPage();

    @Test
    public void testIssueSearchWithLambdaSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        page.openMainPage();
        page.searchRepository();
        page.openTheRepository();
        page.openIssueTab();
        page.searchIssueByNumber(1467);
        page.makeScreenshot();
    }
}
