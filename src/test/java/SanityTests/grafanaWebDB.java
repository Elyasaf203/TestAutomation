package SanityTests;

import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class grafanaWebDB extends commonOps {
    @Test(description = "test_01 login to grafana")
    @Description("test description : login to grafana to application")
    public void Test_01_loginDB()
    {
        webFlows.loginDB();
        verifications.textInElement(grafanamain.txt_mainHeading,"Home");
    }
}
