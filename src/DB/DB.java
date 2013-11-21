
package DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB 
{
    private static final String db = "BINFG31";
    private static final String user = "BINFG31";
    private static final String pass = "aeCahqu3";
    
    public static Connection getConnection() 
    {
        Connection dbConnection = null;
        try 
        {
            //Laden van driver voor MySQL
            Class.forName("com.mysql.jdbc.Driver");
            //of Class<?>.forName("com.mysql.jdbc.Driver");

            //Verbinding aanmaken met de DriverManager
            String protocol = "jdbc" ;
            String subProtocol = "mysql" ;
            String subName = "//mysqlha2.ugent.be/" + db 
                        + "?user=" + user 
                        + "&password=" + pass;
            //RARA vervangen

            String URL = protocol +":"+ subProtocol +":"+ subName; 

            dbConnection = DriverManager.getConnection(URL);
        }
        catch(Exception ex)
        {
            try { dbConnection.close(); } catch(Exception ex2) {}
            dbConnection = null;
            System.out.println(ex.getMessage());
        }
        return dbConnection;
    }
    
}
