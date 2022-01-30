package managmentsystem.ProductManagment;

import java.sql.Connection;
import java.sql.DriverManager;
import managmentsystem.DatabaseHandler;

public class MySqlDataSource implements DataSource {

    public Connection myConnection;
    @Override
    public void createConnection() {
        try{  
        myConnection=DriverManager.getConnection(  
        "jdbc:mysql://localhost:3306/gameshopdatabase","root",""); 
        }catch(Exception e)
        {
            System.out.println("Exception : "+e.getMessage());
            System.out.println(e);
            System.out.println("===================================");
        }  
    }

    @Override
    public Connection getConnection() {
        return myConnection;
    }
    
}
