package SanityTests;
import WorkFlows.electronFlows;
import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.xml.ws.Response;

@Listeners(Utilities.listeners.class)
public class electronDemo extends commonOps
       {
        @Test(description = "test_01 verify screan resolution")
        @Description("test description : Getting thr resolution from app and verify")
        public void  Test_01_login()
        {
           electronFlows.getScreanInfo();
           verifications.textInElement(electronMain.field_screen_info, "Your screen is: 1366px x 768px");
        }

}
