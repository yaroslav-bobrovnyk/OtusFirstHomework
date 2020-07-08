import config.ServerConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class FirstTest {
    final String TITLE="Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям";
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(FirstTest.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        logger.info("Драйвер поднят");
    }
    @Test
    public void openPage() {
        driver.get(cfg.url());
        logger.info("Открыта страница отус");
        Assert.assertEquals("Title страницы не совпадает ",TITLE,driver.getTitle());
        logger.info("Title страницы проверен");
    }
    @After
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
        logger.info("Драйвер отключен");
    }
}
