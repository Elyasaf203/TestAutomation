package Utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public  class listeners extends commonOps implements ITestListener
{
    public void onFinish(ITestContext arg0)
    {
        System.out.println("finish");
    }

    public void onStart(ITestContext arg0)
    {
        System.out.println("--------------Srarting Execution---------------");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0)
    {
        // TODO Auto-generated method stub
    }

    public void onTestFailure(ITestResult test)
    {
        System.out.println("--------------Failde Execution" + test.getName()+"---------------");
        if (!getData("PlatformName").equalsIgnoreCase("api"))
        saveScreenShot();
    }

    public void onTestSkipped(ITestResult arg0)
    {
        // TODO Auto-generated method stub
    }

    public void onTestStart(ITestResult test)
    {
        System.out.println("--------------Srarting Test" + test.getName() +"----------");
    }

    public void onTestSuccess(ITestResult arg0)
    {
        // TODO Auto-generated method stub
    }

    @Attachment(value = "Page Screen Shot",type = "image/png")
    public byte[] saveScreenShot()
    {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
