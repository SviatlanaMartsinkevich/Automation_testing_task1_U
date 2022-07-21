package page;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RiskWarningPage extends BasePage {
    private static String ENDPOINT = "/research/risk_warning";

    private static final By PAGE_OPENED_IDENTIFIER = By.xpath("//h2[text() = 'Notification on Non-Independent Investment Research and Risk Warning']");

    private By riskWarningLinkSelector = By.xpath("//p[contains(text(), 'Trading on any financial market')]/a");
    private By documentWasOpenedInNewTabSelector = By.xpath("//*[@type = 'application/pdf']");

    public RiskWarningPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return super.isPageOpened(PAGE_OPENED_IDENTIFIER);
    }

    public WebElement getRiskWarningLink() {
        return driver.findElement(riskWarningLinkSelector);
    }

    public WebElement getDocumentWasOpenedInNewTab() {
        return driver.findElement(documentWasOpenedInNewTabSelector);
    }

}
