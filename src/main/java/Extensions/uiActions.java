package Extensions;

import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class uiActions extends commonOps
{
    @Step("Click on element")
    public static void click(WebElement elem)
    {
        if (!getData("PlatformName").equalsIgnoreCase("mobile") && !getData("PlatformName").equalsIgnoreCase("electron")&& !getData("PlatformName").equalsIgnoreCase("desktop"))
             whit.until(ExpectedConditions.elementToBeClickable(elem));
          elem.click();
    }
    @Step ("sent text to text field")
    public static void updateText(WebElement elem,String value)
    {
        if (!getData("PlatformName").equalsIgnoreCase("mobile"))
        whit.until(ExpectedConditions.elementToBeClickable(elem));
        elem.sendKeys(value);
    }
    @Step ("updateDropDown")
    public static void updateDropDown(WebElement elem,String value)
    {
        if (!getData("PlatformName").equalsIgnoreCase("mobile"))
        whit.until(ExpectedConditions.visibilityOf(elem));
        Select myValue =new Select(elem);
        myValue.selectByVisibleText(value);
    }
    @Step("mouseHoverElements")
    public static void mouseHoverElements(WebElement elem1,WebElement elem2)
    {
        actions.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }
}








