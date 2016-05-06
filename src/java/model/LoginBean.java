/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


@Named(value = "loginBean")
@RequestScoped
public class LoginBean {

    private String userName;
    private String password;
    private String dbuserName;
 
    private String dbpassword;
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    String SQL;
    
    
    public LoginBean() {
    }
    
  
    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDbuserName() {
		return dbuserName;
	}

	public void setDbuserName(String dbuserName) {
		this.dbuserName = dbuserName;
	}

	public String getDbpassword() {
		return dbpassword;
	}

	public void setDbpassword(String dbpassword) {
		this.dbpassword = dbpassword;
	}

	public void dbData(String userName)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bakeryapp","root","");
            statement = connection.createStatement();
            SQL = "Select * from employee where username like ('" + userName +"')";
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
            dbuserName = resultSet.getString(6).toString();
            dbpassword = resultSet.getString(7).toString();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.out.println("Exception Occured in the process :" + ex);
        }
    }
    
    public String checkValidUser()
    {
        dbData(userName);
 
        if(userName.equalsIgnoreCase(dbuserName))
        {
 
            if(password.equals(dbpassword))
                return "customermenu";
            else
            {
                return "failure";
            }
        }
        else
        {
            return "failure";
        }
    } 
    
    
}
