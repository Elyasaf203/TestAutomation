package PageObjects.Calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class mainPage
{
    @FindBy(how = How.NAME,using = "Clear")
    public WebElement btn_clear;

    @FindBy(how = How.NAME,using = "One")
    public WebElement btn_one;

    @FindBy(how = How.NAME,using = "Plus")
    public WebElement btn_plus;

    @FindBy(how = How.NAME,using = "Seven")
    public WebElement btn_seven;

    @FindBy(how = How.NAME,using = "Equals")
    public WebElement btn_equals;

    @FindBy(how = How.XPATH,using = "//*[@AutomationId='CalculatorResults']")
    public WebElement btn_field_results;

}

