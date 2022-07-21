package baseEntities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import utils.Waits;

public abstract class BasePage {
    protected WebDriver driver;
    protected Waits waits;

    private static final Logger logger = LogManager.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver);
    }

    public boolean isPageOpened(By by) {
        try {
            logger.info("Page is opened");
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException nsex) {
            logger.info(nsex);
            return false;
        }
    }
}

