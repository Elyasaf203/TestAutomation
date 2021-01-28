package PageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class serverAdminMainPage
{
    @FindBy(how = How.XPATH,using = "//td[@class='width-4 text-center link-td']")
    public List<WebElement> rows;

    @FindBy(how = How.XPATH,using = "//span[@class='css-1beih13']")
    public WebElement btn_newUser;

}
