import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class SelenideTest extends BaseTest {

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
    
    //тест с намеренной ошибкой
    @Тест
    public void testSelenideNoIssue() {
        //создание лога
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(false));

        
        page.openMainPage ();
        page.searchRepository ();
        page.openTheRepository ();      
        page.openIssueTab;
        page.searchIssueByNumber (9999);
    }
}
