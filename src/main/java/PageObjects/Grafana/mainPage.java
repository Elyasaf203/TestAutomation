package PageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class mainPage
{
    @FindBy(how = How.XPATH,using = "/html/body/grafana-app/div/div/react-container/div/div[1]/div[1]/div/a")
    public WebElement txt_mainHeading;
}
