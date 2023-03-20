package kochetkov.allure;

import org.junit.jupiter.api.Test;

public class AnnotatedAttachmentTest extends TestBase {

    public final static String REPOSITORY = "IlyaKoch/allure-reports";

    @Test
    public void testGitHub() {
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssueTab();
        steps.checkForAvailableIssueWithNumber();
    }
}