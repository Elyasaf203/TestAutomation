package PageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class loginPage
{
    @FindBy(how = How.NAME,using = "user")
    public  WebElement txt_username;

    @FindBy (how = How.NAME,using = "password")
    public WebElement txt_password;

    @FindBy (how = How.XPATH,using = "/html/body/grafana-app/div/div/react-container/div/div/div[2]/div/div/form/button/span")
    public WebElement btn_login;

    @FindBy (how = How.XPATH,using = "/html/body/grafana-app/div/div/react-container/div/div/div[2]/div/form/div[3]/div[2]/a/span")
    public WebElement btn_skip;
}
