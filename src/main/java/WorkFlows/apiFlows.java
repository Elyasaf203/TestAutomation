package WorkFlows;

import Extensions.apiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class apiFlows extends commonOps {

    @Step("Get Team From Grafana")
    public  static String getTeamProperty(String jPath)
    {
        Response response = apiActions.get("/api/teams/search");
        return apiActions.extractFromJSON(response,jPath);
    }
    @Step("Create New in Grafana")
    public  static void postTeam(String name,String emile)
    {
        requestParams.put("name",name);
        requestParams.put("email",emile);
        apiActions.post(requestParams,"/api/teams");
    }

    @Step("Update Team in Grafana")
    public  static void updateTeam(String name,String emile,String id)
    {
        requestParams.put("name",name);
        requestParams.put("email",emile);
        apiActions.put(requestParams,"/api/teams/" +id);
    }
    @Step("Delete Team in Grafana")
    public  static void deleteTeam()
    {
        apiActions.deleteTeams(getID());
    }

    @Step("")
    public static String getID()
    {
        String id=apiActions.get("http://localhost:3000/api/teams/search?teams/id").prettyPrint();
        String getid =id.substring(66,68);
        return getid;
    }

}