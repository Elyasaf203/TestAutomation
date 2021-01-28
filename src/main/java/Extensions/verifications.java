package Extensions;

import Utilities.base;
import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class verifications extends commonOps
{
    @Step("verify text in element")
    public static void textInElement(WebElement elem,String expectedValue)
    {
        if (!getData("PlatformName").equalsIgnoreCase("mobile")&& !getData("PlatformName").equalsIgnoreCase("electron") && !getData("PlatformName").equalsIgnoreCase("desktop") )
             whit.until(ExpectedConditions.visibilityOf(elem));
        if (getData("PlatformName").equalsIgnoreCase("desktop"))
            assertEquals(elem.getText().replaceAll("Display is","").trim(),expectedValue);
        else
            assertEquals(elem.getText(),expectedValue);
    }
    @Step("verify the num of element equals to")
    public static void numberOfElements(List <WebElement> elems,int expectedValue)
    {
        if (!getData("PlatformName").equalsIgnoreCase("mobile"))
        whit.until(ExpectedConditions.visibilityOf(elems.get(elems.size()-1)));
        assertEquals(elems.size(),expectedValue);
    }
    @Step("verify Element Visually")
    public static void visualElement  (WebElement imageElement, String expectedImageName)
    {
        BufferedImage expectedImage = null;
        try
        {
            expectedImage = ImageIO.read(new File(getData("ImageRepo")+expectedImageName + ".png"));
        }
        catch (Exception e)
        {
            System.out.println("Error reading image file" + e);
        }
        Screenshot imageScreanShot = new AShot().takeScreenshot(driver,imageElement);
        BufferedImage actualImage = imageScreanShot.getImage();
        diff = imgDiff.makeDiff(actualImage,expectedImage);
        assertFalse(diff.hasDiff(),"Images are not the same");
    }
    @Step("Verify text whit text")
    public static void text(String actualText,String expectedText)
    {
        assertEquals(actualText,expectedText);
    }
}
