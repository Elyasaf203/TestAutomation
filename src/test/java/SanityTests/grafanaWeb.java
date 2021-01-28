package SanityTests;

import Extensions.uiActions;
import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.webFlows;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners (Utilities.listeners.class)
public class grafanaWeb extends commonOps
{
    @Test(description = "test_01 login to grafana")
    @Description("test description : login to grafana to application")
    public void Test_01_login()
    {
        webFlows.login(getData("user"),getData("password"));

        verifications.textInElement(grafanamain.txt_mainHeading,"Home");
    }

    @Test(description = "test_02 verify default users")
    @Description("test description : verify the default the number of users (shold be 1")
    public void Test_02_verifyDefaultUsers()
    {
      uiActions.mouseHoverElements(grafanaLeftMenu.btn_serverAdmin,grafanaServerAdminMenuPage.link_users);
      verifications.numberOfElements(grafanaServerAdminMainPage.rows,1);
    }

    @Test(description = "test_03 add and verify users ")
    @Description("test description : add a new user and verify the number of users (shold be 2)")
    public void Test_03_addAndVerifyusers()
    {
        uiActions.mouseHoverElements(grafanaLeftMenu.btn_serverAdmin,grafanaServerAdminMenuPage.link_users);
        webFlows.createUser("Elyasrgdff","ELy34355@gmail.com","elyodfgyon","12356e56");
        verifications.numberOfElements(grafanaServerAdminMainPage.rows,2);
    }

    @Test(description = "test_04 delete last user and verifyusers ")
    @Description("test description : delete last created user and verify the number of users (shold be 1)")
    public void Test_04_deleteAndVerify() throws InterruptedException
    {
        uiActions.mouseHoverElements(grafanaLeftMenu.btn_serverAdmin,grafanaServerAdminMenuPage.link_users);
        webFlows.deleteLastUser();
        Thread.sleep(500);
        verifications.numberOfElements(grafanaServerAdminMainPage.rows,1);
    }
    @Test(description = "test_05 Verify Avatar ")
    @Description("test description :  Verify Grafana Avatar")
    public void Test_0_Verify_Avatar() throws InterruptedException
    {
        verifications.visualElement(grafanaLeftMenu.Avatar,"grafanaAvatar");
    }


}
