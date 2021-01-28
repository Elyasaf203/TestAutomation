package Utilities;

import java.sql.DriverManager;

public class managaDB extends commonOps{
    public static void initConnection(String dbURL,String user,String pass)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dbURL,user,pass);
            stmt = con.createStatement();
        }
        catch (Exception e)
        {
            System.out.println("Error Occured while Connection to DB , see details" + e);
        }
    }
    public static void closeConnection()
    {
        try {
            con.close();
        }
        catch (Exception e)
        {
            System.out.println("Error Occured while Closing to DB");
        }


    }
}
