import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnnotatedStepsTest extends BaseTest {

    private WebSteps steps = new WebSteps();

    @Test
    @Feature("Issues")
    @Owner("slazarska")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Github", url = "https://github.com")
    @DisplayName("Check the issue can be found by the number")
    public void testIssueSearchWithAnnotatedSteps() {
        steps.openMainPage();
        steps.searchRepository();
        steps.openTheRepository();
        steps.openIssueTab();
        steps.searchIssueByNumber(1467);
        steps.makeScreenshot();
    }
}
