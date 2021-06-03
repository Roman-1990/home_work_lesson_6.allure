import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class LambdaStepsTest extends BaseTest{

    private static final int ISSUE_NUMBER = 1467;
    private WebPage page = new WebPage();

    @Test
    public void testIssueSearchWithLambdaSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open main github page", (s) -> {
            s.parameter("URL", page.BASE_URL);
            page.openMainPage();
        });

        step("Search the repository " + page.REPOSITORY, (s) -> {
            s.parameter("repository", page.REPOSITORY);
            page.searchRepository();
        });

        step("Open the repository " + page.REPOSITORY, (s) -> {
            s.parameter("repository", page.REPOSITORY);
            page.openTheRepository();
        });

        step("Open tab Issues in the repository", () -> {
            page.openIssueTab();
        });

        step("Check the Issue num " + ISSUE_NUMBER + " is displayed", (s) -> {
            s.parameter("number", ISSUE_NUMBER);
            page.searchIssueByNumber(ISSUE_NUMBER);
        });

        step("Make screenshot", () -> {
            page.makeScreenshot();
        });
    }
}
