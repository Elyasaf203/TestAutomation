package WorkFlows;

import Extensions.dbActions;
import Extensions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;

import java.util.List;

public class webFlows extends commonOps
{
    @Step ("Login Grafana")
    public static void login(String user, String password)
    {
        uiActions.updateText(grafanalogin.txt_username,user);
        uiActions.updateText(grafanalogin.txt_password,password);
        uiActions.click(grafanalogin.btn_login);
        uiActions.click(grafanalogin.btn_skip);
    }

    @Step ("Login Grafana flow with DB Credentials")
    public static void loginDB()
    {
        List <String> cred = dbActions.getCredentials("SELECT Name,Password FROM Test WHERE id='5'");
        uiActions.updateText(grafanalogin.txt_username,cred.get(0));
        uiActions.updateText(grafanalogin.txt_password,cred.get(1));
        uiActions.click(grafanalogin.btn_login);
        uiActions.click(grafanalogin.btn_skip);
    }

    @Step ("Create new user")
    public static void createUser(String name,String email,String username,String password)
    {
        uiActions.click(grafanaServerAdminMainPage.btn_newUser);
        uiActions.updateText(grafanaUserListPage.txt_name,name);
        uiActions.updateText(grafanaUserListPage.txt_email,email);
        uiActions.updateText(grafanaUserListPage.txt_username,username);
        uiActions.updateText(grafanaUserListPage.txt_password,password);
        uiActions.click(grafanaUserListPage.txt_CreateUser);
    }
    @Step ("Delete last user from table")
    public static void deleteLastUser()
    {
        uiActions.click(grafanaServerAdminMainPage.rows.get(grafanaServerAdminMainPage.rows.size()-1));
        uiActions.click(grafanaUserListPage.btn_deleteUser);
        uiActions.click(grafanaUserListPage.btn_confirmDelete);
    }



}
