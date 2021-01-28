package SanityTests;

import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.calcflows;
import WorkFlows.electronFlows;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class calculatorDesktop extends commonOps
{
    @Test(description = "test_01 verify Addition Command ")
    @Description("test description :verift Addition Command in Calculator")
    public void  Test_01_addition()
    {
        calcflows.CalculateAddition();
        verifications.textInElement(calcMain.btn_field_results, "8");
    }

}
