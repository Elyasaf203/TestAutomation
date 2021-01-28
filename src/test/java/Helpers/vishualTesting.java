package Helpers;

import Utilities.HelperMethods;
import Utilities.commonOps;
import WorkFlows.webFlows;
import org.testng.annotations.Test;

import java.io.IOException;

public class vishualTesting extends commonOps
{
    @Test
    public void creatScreanShot() throws IOException
    {
        //webFlows.login("admin","admin");
        HelperMethods.TakeElementScreanShot(grafanaLeftMenu.Avatar,"grafanaAvatar");
    }
}