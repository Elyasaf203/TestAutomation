package SanityTests;

import Extensions.apiActions;
import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.apiFlows;
import io.qameta.allure.Description;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class grafanaAPI extends commonOps {
    @Test(description = "Get Team From Grafana")
    @Description("test description : Login to grafana and get team")
    public void Test_01_GetTeam() {
        //verifications.text(apiFlows.getTeamProperty("teams[0].name"),"ElyasafTeam");
    }

    @Test(description = "Add Team And Vrerify it")
    @Description("test description : Add Team To Grafana And Vrerify it")
    public void Test_02_AddTeam_andVerify() {
        apiFlows.postTeam("Mazal","Mazal@gmail.com");
        verifications.text(apiFlows.getTeamProperty("teams[0].name"),"Mazal");
        verifications.text(apiFlows.getTeamProperty("totalCount"), "1");
    }

    @Test(description = "Update Team And Vrerify it")
    @Description("test description : Update Team And Vrerify it")
    public void Test_03_updateTeam_andVerify() {
        apiFlows.updateTeam("Mazal00", "Mazal00@gmail.com", apiFlows.getID());
        verifications.text(apiFlows.getTeamProperty("teams[0].name"), "Mazal00");
    }

    @Test(description = "Delete Team And Vrerify it")
    @Description("test description : Delete Team And Vrerify it")
    public void Test_04_DeleteTeam_andVerify() {
        apiFlows.deleteTeam();
        verifications.text(apiFlows.getTeamProperty("totalCount"), "0");
    }


}
