package Utilities;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
//import net.sf.cglib.asm.$FieldVisitor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class commonOps extends base {


    public static void readXmlFile()
    {
        DocumentBuilder dBuilder;
        File fXmlFile = new File("C:/Automation/Configoration/dataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        } catch (Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
    }
    public static String getData(String value) {
        if (doc == null) {
            readXmlFile();
        }
        return doc.getElementsByTagName(value).item(0).getTextContent();
    }


    public static void initBrowser(String browserType)
    {
        if (browserType.equalsIgnoreCase("chrome"))
            driver =initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver =initFFDriver();
        else if (browserType.equalsIgnoreCase("ie"))
            driver =initIEDriver();
        else
            throw new RuntimeException("invalid platform name stated");
        driver.manage().window().maximize();
        driver.get(getData("url"));
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
        whit = new WebDriverWait(driver,Long.parseLong(getData("TimeOut")));
        actions =new Actions(driver);
    }
    public static WebDriver initChromeDriver()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }
    public static WebDriver initFFDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }
    public static WebDriver initIEDriver()
    {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    public static void initMobile()
    {
        dc.setCapability(MobileCapabilityType.UDID,getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,getData("APP_PACKAGE"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,getData("APP_ACTIVITY"));
        try
        {
            driver = new RemoteWebDriver(new URL(getData("Appium_Server")+ "/wd/hub"),dc);
        }
        catch (Exception e)
        {
            System.out.println("Can not connect to Appium Server,see Details:" + e);
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")),TimeUnit.SECONDS);
    }

    public static void initAPI()
    {
        RestAssured.baseURI = getData("url_api");
        httpRequest = RestAssured.given().auth().preemptive().basic(getData("user"),getData("password"));
    }

    public static void initElectron() {
        File file = new File(getData("ElectronAppPath"));
        System.out.println("******************* "+ file.exists() + " "+ getData("ElectronAppPath"));
        System.setProperty("webdriver.chrome.driver", getData("ElectronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("ElectronAppPath"));
        dc.setCapability("chromeOptions", opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
    }
    public static void initDesktop()
    {
        dc.setCapability("app",getData("Calculator_App"));
        try
        {
            driver = new WindowsDriver(new URL(getData("Appium_Server")),dc);
        }
        catch (Exception e)
        {
            System.out.println("Can not connect to Desktop Server,see Details:" + e);
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")),TimeUnit.SECONDS);
    }

    @BeforeClass
    //@Parameters ("PlatformName")
    public void startSession()
    {
        //Platform =PlatformName;
        if(getData("PlatformName").equalsIgnoreCase("web"))
            initBrowser(getData("BrowserName"));
        else if(getData("PlatformName").equalsIgnoreCase("mobile"))
            initMobile();
        else if (getData("PlatformName").equalsIgnoreCase("api"))
            initAPI();
        else if  (getData("PlatformName").equalsIgnoreCase("electron"))
            initElectron();
        else if  (getData("PlatformName").equalsIgnoreCase("desktop"))
            initDesktop();
        else
            throw new RuntimeException(("invalid Platfor name stated"));
        managesPages.init();
        managaDB.initConnection(getData("dbURL"),getData("dbUser"),getData("dbPass"));
    }
    @AfterMethod
    public void afterMethod()
    {
            if (getData("PlatformName").equalsIgnoreCase("web"))
            driver.get(getData("url"));
    }

    @AfterClass
    public void closeSession()
    {
        managaDB.closeConnection();
        if (!getData("PlatformName").equalsIgnoreCase("api"))
        driver.quit();
    }
}
