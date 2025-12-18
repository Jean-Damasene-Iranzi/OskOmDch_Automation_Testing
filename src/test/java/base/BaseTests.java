package base;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

    public class BaseTests {

        private WebDriver driver;
        protected HomePage homePage;

        @BeforeClass
        public void setUp(){
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
            driver = new ChromeDriver();
            goHome();
            homePage = new HomePage(driver);
        }

        @BeforeMethod
        public void goHome(){
            driver.get("https://askomdch.com/");
        }

        @AfterClass
        public void tearDown(){
//            driver.quit();
        }
    }

