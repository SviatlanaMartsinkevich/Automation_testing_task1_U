package page;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EconomicCalendarPage extends BasePage {
    private static String ENDPOINT = "/research/economicCalendar";
    private static final By PAGE_OPENED_IDENTIFIER = By.id("timeFrame_yesterday");

    private By yesterdayFieldSelector = By.id("timeFrame_yesterday");
    private By todayFieldSelector = By.id("timeFrame_today");
    private By tomorrowFieldSelector = By.id("timeFrame_tomorrow");
    private By thisWeekFieldSelector = By.id("timeFrame_thisWeek");
    private By widgetFieldDateRangeSelector = By.id("widgetFieldDateRange");
    private By hereLinkSelector = By.xpath("//a[@href='/research/risk_warning']");

    private By timeZoneFieldSelector = By.id("timeZoneGmtOffsetFormatted");
    private By iFrame = By.xpath("//iframe[@title='economicCalendar']");

    public EconomicCalendarPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return super.isPageOpened(PAGE_OPENED_IDENTIFIER);
    }

    public WebElement getIFrame() {
        return driver.findElement(iFrame);
    }

    public WebElement getYesterdayField() {
        return driver.findElement(yesterdayFieldSelector);
    }

    public WebElement getTodayField() {
        return driver.findElement(todayFieldSelector);
    }

    public WebElement getTomorrowField() {
        return driver.findElement(tomorrowFieldSelector);
    }

    public WebElement getThisWeekField() {
        return driver.findElement(thisWeekFieldSelector);
    }

    public WebElement getWidgetFieldDateRange() {
        return driver.findElement(widgetFieldDateRangeSelector);
    }

    public WebElement getHereLink() {
        return driver.findElement(hereLinkSelector);
    }

    public WebElement getTimeZoneField(){
        return driver.findElement(timeZoneFieldSelector);
    }
}
