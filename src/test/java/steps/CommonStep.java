package steps;

import baseEntities.BaseStep;
import core.ReadProperties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.EconomicCalendarPage;
import page.HomePage;

import java.util.Set;

public class CommonStep extends BaseStep {
    private EconomicCalendarPage economicCalendarPage;
    private HomePage homePage;

    public CommonStep(WebDriver driver) {
        super(driver);
    }

    public HomePage acceptCookie() {
        homePage = new HomePage(driver);
        if (!homePage.getAcceptCookieButton().isSelected()) {
            homePage.getAcceptCookieButton().click();
        }
        return homePage;
    }

    public String gettingCurrentTimeZone(){
        economicCalendarPage = new EconomicCalendarPage(driver);
        String currentTimeZone = economicCalendarPage.getTimeZoneField().getText();
        String correctFormat = currentTimeZone.substring(1,currentTimeZone.length()-4).replace(" ","");
        return correctFormat;
    }
    public EconomicCalendarPage checkTodayDate(WebElement element, String actualDate) {
        economicCalendarPage = new EconomicCalendarPage(driver);
        economicCalendarPage.getTodayField().click();
        waits.waitUntilTextChange(element, actualDate);
        return economicCalendarPage;
    }

    public EconomicCalendarPage checkYesterdayDate(WebElement element, String actualDate) {
        economicCalendarPage = new EconomicCalendarPage(driver);
        economicCalendarPage.getYesterdayField().click();
        waits.waitUntilTextChange(element, actualDate);
        return economicCalendarPage;
    }

    public EconomicCalendarPage checkTomorrowDate(WebElement element, String actualDate) {
        economicCalendarPage = new EconomicCalendarPage(driver);
        economicCalendarPage.getTomorrowField().click();
        waits.waitUntilTextChange(element, actualDate);
        return economicCalendarPage;
    }

    public EconomicCalendarPage checkThisWeekDate(WebElement element, String actualDate) {
        economicCalendarPage = new EconomicCalendarPage(driver);
        economicCalendarPage.getThisWeekField().click();
        waits.waitUntilTextChange(element, actualDate);
        return economicCalendarPage;
    }

    public EconomicCalendarPage goToEconomicCalendarPage() {
        scrollToElementAndClick(homePage.getResearchAndEducationField());
        scrollToElementAndClick(homePage.getEconomicCalendarField());
        return economicCalendarPage;
    }

    public void goToCalendar() {
        EconomicCalendarPage economicCalendarPage = new EconomicCalendarPage(driver);
        waitForPageLoaded();
        switchToFrame(economicCalendarPage.getIFrame());
    }

    public void switchToFrame(WebElement element) {
        driver.switchTo().frame(element);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void switchToWindow() {
        String parentWindow = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String windowHandle : handles) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
    }

    public void scrollToElementAndClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void waitForPageLoaded() {
        new WebDriverWait(driver, ReadProperties.getTimeOut()).until(
                webDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }
}
