package PageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class leftMenuPage
{
        @FindBy(how = How.XPATH,using = "//div[@class='sidemenu-item dropdown'][7]")
        public WebElement btn_serverAdmin;

        @FindBy(how = How.CSS,using = "img[src='/avatar/46d229b033af06a191ff2267bca9ae56']")
        public WebElement Avatar ;

}
