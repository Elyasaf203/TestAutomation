package Extensions;

import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class dbActions extends commonOps {
    @Step("Get Credentials from DB")
    public static  List<String> getCredentials(String query)
    {
        List<String> credentials = new ArrayList<String>();
        try {
            rs =stmt.executeQuery(query);
            rs.next();
            credentials.add(rs.getString(1));
            credentials.add(rs.getString(2));
//            System.out.println("+++++++++ user name is:" +rs.getString(1));
//            System.out.println("+++++++++ password is:" +rs.getString(2));
        }
        catch (Exception e)
        {
            System.out.println("Error Occured while priniting table data ");
        }
        return credentials;

    }

}
