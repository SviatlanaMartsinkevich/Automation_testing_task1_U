package tests;

import baseEntitie.BaseTest;
import org.apache.logging.log4j.core.util.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page.EconomicCalendarPage;
import page.RiskWarningPage;
import steps.CommonStep;
import utils.DateClass;

@RunWith(Parameterized.class)
public class CommonTest extends BaseTest {
    DateClass dateClass = new DateClass();

   @Test
    public void checkDateTest() {
        CommonStep commonStep = new CommonStep(driver);
        commonStep.acceptCookie();

        commonStep.goToEconomicCalendarPage();
        commonStep.goToCalendar();

        EconomicCalendarPage economicCalendarPage = new EconomicCalendarPage(driver);

        commonStep.checkYesterdayDate(economicCalendarPage.getWidgetFieldDateRange(), economicCalendarPage.getWidgetFieldDateRange().getText());

        Assertions.assertEquals(economicCalendarPage.getWidgetFieldDateRange().getText(), dateClass.getYesterdayDate(commonStep.gettingCurrentTimeZone()));

        commonStep.checkTodayDate(economicCalendarPage.getWidgetFieldDateRange(), economicCalendarPage.getWidgetFieldDateRange().getText());
        Assertions.assertEquals(economicCalendarPage.getWidgetFieldDateRange().getText(), dateClass.getTodayDate(commonStep.gettingCurrentTimeZone()));

        commonStep.checkTomorrowDate(economicCalendarPage.getWidgetFieldDateRange(), economicCalendarPage.getWidgetFieldDateRange().getText());
        Assertions.assertEquals(economicCalendarPage.getWidgetFieldDateRange().getText(), dateClass.getTomorrowDate(commonStep.gettingCurrentTimeZone()));

        commonStep.checkThisWeekDate(economicCalendarPage.getWidgetFieldDateRange(), economicCalendarPage.getWidgetFieldDateRange().getText());
        Assertions.assertEquals(economicCalendarPage.getWidgetFieldDateRange().getText(), dateClass.getWeekDate(commonStep.gettingCurrentTimeZone()));
    }

    @Test
    public void getRiskWarningDocumentTest() {
        CommonStep commonStep = new CommonStep(driver);
        commonStep.acceptCookie();

        commonStep.goToEconomicCalendarPage();

        EconomicCalendarPage economicCalendarPage = new EconomicCalendarPage(driver);
        commonStep.scrollToElementAndClick(economicCalendarPage.getHereLink());

        RiskWarningPage riskWarningPage = new RiskWarningPage(driver);
        commonStep.scrollToElementAndClick(riskWarningPage.getRiskWarningLink());

        commonStep.switchToWindow();
        Assertions.assertTrue(riskWarningPage.getDocumentWasOpenedInNewTab().isDisplayed());
    }
}
