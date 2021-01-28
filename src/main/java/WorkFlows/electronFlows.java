package WorkFlows;
import Extensions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;

public class electronFlows extends commonOps
{
    @Step("getScreanInfo")
    public static void getScreanInfo()
    {
        uiActions.click(electronMain.btn_windows);
        uiActions.click(electronMain.btn_info);
        uiActions.click(electronMain.btn_demo_toggle);
        uiActions.click(electronMain.btn_demo_toggle);
        uiActions.click(electronMain.btn_screen_info);
        uiActions.click(electronMain.field_screen_info);
    }
}
