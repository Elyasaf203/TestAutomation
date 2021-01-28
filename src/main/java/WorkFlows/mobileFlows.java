package WorkFlows;

import Extensions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;

public class mobileFlows extends commonOps {

    @Step("Fill in Form and Calculate Mortgage")
    public static void calculate (String amount,String term,String rate)
    {
          //mortgageMain.txt_amount.sendKeys(amount);
        uiActions.updateText(mortgageMain.txt_amount,amount);
        uiActions.updateText(mortgageMain.txt_term,term);
        uiActions.updateText(mortgageMain.txt_rate,rate);
        uiActions.click(mortgageMain.btn_calculate);
    }

}
