
package model;

import java.sql.*;

public class MySqlCon {
    public static void main(String[] args){
        try{
            
           Class.forName("com.mysql.jdbc.Driver");
           
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bakeryapp?zeroDateTimeBehavior=convertToNull", "root", "");
           
           Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery("select * from employee");
            while (rs.next()){
                System.out.println(rs.getInt(1)+""+
                                   rs.getString(2)+""+
                                   rs.getString(3)+""+
                                   rs.getString(4)+""+
                                   rs.getString(5)+""+
                                   rs.getString(6)+""+
                                   rs.getString(7));
            }
            con.close();
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        
    }
}
