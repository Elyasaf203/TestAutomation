package Utilities;

import Mortgage.mainPage;
//import org.apache.xalan.lib.Extensions;
import PageObjects.Grafana.*;
import org.openqa.selenium.support.PageFactory;

public class managesPages extends base
{
    public static void init()
    {
        grafanalogin = PageFactory.initElements(driver, PageObjects.Grafana.loginPage.class);
        grafanamain = PageFactory.initElements(driver, PageObjects.Grafana.mainPage.class);
        grafanaLeftMenu = PageFactory.initElements(driver,PageObjects.Grafana.leftMenuPage.class);
        grafanaServerAdminMenuPage = PageFactory.initElements(driver, PageObjects.Grafana.serverAdminMenuPage.class);
        grafanaServerAdminMainPage = PageFactory.initElements(driver, PageObjects.Grafana.serverAdminMainPage.class);
        grafanaUserListPage = PageFactory.initElements(driver, PageObjects.Grafana.userListPage.class);




        mortgageMain = PageFactory.initElements(driver,Mortgage.mainPage.class);
        electronMain = PageFactory.initElements(driver, PageObjects.ElectronDemo.mainPage.class);
        calcMain = PageFactory.initElements(driver, PageObjects.Calculator.mainPage.class);
        //jp = PageFactory.initElements(driver, Extensions.apiActions.difference(jp).class);
        //jp =PageFactory.initElements(driver,Extensions.uiActions.class);

    }
}
