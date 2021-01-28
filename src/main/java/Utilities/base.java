package Utilities;

import com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import java.security.cert.Extension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import Utilities.commonOps;


public class base
{
    public static WebDriver driver;
    public static WebDriverWait whit;
    public static Actions actions;
    public static Screenshot imageScreanShot;
    public static ImageDiffer imgDiff = new ImageDiffer();
    public static ImageDiff diff;
    public static DesiredCapabilities dc = new DesiredCapabilities();
    public  static Document doc = null;

    //public static String Platform;
    public static PageObjects.Grafana.loginPage grafanalogin;
    public static PageObjects.Grafana.mainPage grafanamain;
    public static PageObjects.Grafana.leftMenuPage grafanaLeftMenu;
    public static PageObjects.Grafana.serverAdminMenuPage grafanaServerAdminMenuPage;
    public static PageObjects.Grafana.serverAdminMainPage grafanaServerAdminMainPage;
    public static PageObjects.Grafana.userListPage grafanaUserListPage;
    ;

    public static Mortgage.mainPage mortgageMain;
    public static PageObjects.ElectronDemo.mainPage electronMain;
    public static PageObjects.Calculator.mainPage calcMain;

    public static RequestSpecification httpRequest;
    public static Response response;
    public static JSONObject requestParams = new JSONObject();
    public static JsonPath jp;

    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;




}
