import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps {

    private static final String BASE_URL = "https://github.com";
    private static final String REPOSITORY = "selenide/selenide";

    public SelenideElement searchField = $(".header-search-input"),
            tabIssues = $(withText("Issues"));

    @Step("Open main github page")
    public void openMainPage() {
        open(BASE_URL);
    }

    @Step("Search the repository {repository}")
    public void searchRepository() {
        searchField.setValue(REPOSITORY).submit();
    }

    @Step("Open the repository {repository}")
    public void openTheRepository() {
        $(By.linkText(REPOSITORY)).click();
    }

    @Step("Open tab Issues in the repository {repository}")
    public void openIssueTab() {
        tabIssues.click();
    }

    @Step("Check the Issue number {number} is displayed")
    public void searchIssueByNumber(int number) {
        $(withText("#" + number)).should(Condition.visible);
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] makeScreenshot() {
        return screenshot(OutputType.BYTES);
    }
}
