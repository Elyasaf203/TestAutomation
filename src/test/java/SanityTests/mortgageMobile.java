package SanityTests;

import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.mobileFlows;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class mortgageMobile extends commonOps {

    @Test(description = "test_01 verify Mortgage")
    @Description("test description : Fill in Mortgage fields and calculate Repayment")
    public void Test_01_verifyRepayment()
    {
        mobileFlows.calculate("1000","3","4");
        verifications.textInElement(mortgageMain.txt_repayment,"£30.03");
    }
}
