/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managmentsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author DELL
 */
public class DatabaseHandler {
    public Connection myConnection;
    public DatabaseHandler() {    }
    public void init(){
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
    
    public Connection getMyConnection(){
        return myConnection;
    }
    
    public String insertRecord(String query){
         
        try{
            System.out.println("Database");
        Statement stmt=myConnection.createStatement();  
        int rows=stmt.executeUpdate(query);  
        return "Query executed successfully "+rows;
        }
        catch(Exception ex){
            return ex.getMessage();
        }
    }
    public ResultSet getAllRecords(String query)
    {
        try{
            System.out.println("DATABASE: SUCCESSFUL");
            Statement stmt=myConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        }catch(SQLException e){ 
            System.out.println("DATABASE: FAILED");
            return null;
        }
    }
    public ResultSet getById(String query)
    {
        try{
            System.out.println("database");
            Statement stmt=myConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
           
            return rs;
        }catch(SQLException e){ 
            System.out.println(e.toString());
            return null;
        }
    }
    public String editRecord(String query)
    {
        try{
        Statement stmt=myConnection.createStatement();  
        int rows=stmt.executeUpdate(query);  
        return "record updated with effectoed rows "+rows;
        }
        catch(Exception ex){
            return ex.getMessage();
        }
    }
    public String deleteRecord(String query)
    {
        try{
        Statement stmt=myConnection.createStatement();  
        int row=stmt.executeUpdate(query);  
        return "Query Succesful";
        }
        catch(Exception ex){
            return "Unsuccesful";
        }
    }
}
