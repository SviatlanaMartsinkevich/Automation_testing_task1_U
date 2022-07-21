package page;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    private static final By PAGE_OPENED_IDENTIFIER = By.xpath("//div[@class = 'xm_app_intro__img']");
    private static final By PAGE_OPENED_IDENTIFIER_COOKIE = By.xpath("//div[@class = 'modal-content']");

    private By acceptCookieButtonSelector = By.xpath("//button[contains(@class, 'btn btn-block btn-r')]");
    private By researchAndEducationFieldSelector = By.xpath("//li[@class='main_nav_research']/a");
    private By economicCalendarFieldSelector = By.xpath("//li[@class='menu-research']//*[contains(text(), 'Economic Calendar')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return super.isPageOpened(PAGE_OPENED_IDENTIFIER_COOKIE);
    }

    public WebElement getAcceptCookieButton() {
        return driver.findElement(acceptCookieButtonSelector);
    }

    public WebElement getResearchAndEducationField() {
        return driver.findElement(researchAndEducationFieldSelector);
    }

    public WebElement getEconomicCalendarField() {
        return driver.findElement(economicCalendarFieldSelector);
    }
}
