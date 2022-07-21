package baseEntitie;

import core.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    @Parameterized.Parameter
    public String screen_size;

    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    @Before
    public void setUp() {
        switch (ReadProperties.getBrowserName().toLowerCase()) {
            case "chrome":
                logger.info("Setup driver");
                WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--silent");
                chromeOptions.setHeadless(ReadProperties.isHeadless());
                chromeOptions.addArguments(screen_size);

                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                logger.info("Setup driver");
                WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                logger.info("Setup driver");
                WebDriverManager.getInstance(DriverManagerType.EDGE).setup();
                driver = new EdgeDriver();
                break;
            default:
                logger.info("This type of browser is not supported.");
                break;
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logger.info("Get URL");
        driver.get(ReadProperties.getUrl());
    }

    @After
    public void tearDown() {
        logger.info("Driver quit");
        driver.quit();
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> differentScreenData() {
        return Arrays.asList(new Object[][]{
                {"--window-size=1024, 768"},
                {"--start-maximized"},
                {"--window-size=800, 600"}
        });
    }
}
