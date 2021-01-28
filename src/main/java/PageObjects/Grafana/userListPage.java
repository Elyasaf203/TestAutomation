package PageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class userListPage
{
    @FindBy(how = How.CSS,using = "input[name=name")
    public WebElement txt_name;

    @FindBy(how = How.CSS,using = "input[name=email")
    public WebElement txt_email;

    @FindBy(how = How.CSS,using = "input[name=login")
    public WebElement txt_username;

    @FindBy(how = How.CSS,using = "input[type=password")
    public WebElement txt_password;

    @FindBy(how = How.CSS,using = "span[class=css-1beih13]")
    public WebElement txt_CreateUser;

    @FindBy(how = How.XPATH,using = "//button[1][@class='css-1scyk9l-button']/span/span['Delete User'][1]")
    public WebElement btn_deleteUser;

    @FindBy(how = How.XPATH,using = "//html/body/div/div/div[1]/div[2]/div/div[2]/div[1]/button/span/span")
    public WebElement btn_confirmDelete;






}
