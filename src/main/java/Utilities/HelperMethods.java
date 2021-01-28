package Utilities;

import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class HelperMethods extends commonOps
{
    public static void TakeElementScreanShot(WebElement imageElement,String imageName) throws IOException
    {
        //imageScreanShot = new AShot().coordsProvider((new WebDriverCoordsProvider().takeScreenshot(driver,imageElement);
        imageScreanShot = new AShot().takeScreenshot(driver,imageElement);
        try
        {
            ImageIO.write(imageScreanShot.getImage(),"png",new File( getData("ImageRepo")+imageName+".png"));
        }
      catch (Exception e)
      {
          System.out.println("Error writing image file, see details" +e);
      }
    }
}
