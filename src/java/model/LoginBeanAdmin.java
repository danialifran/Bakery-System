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


@Named(value = "loginBeanAdmin")
@RequestScoped
public class LoginBeanAdmin {

    private String userName;
    private String password;
    
    
    public LoginBeanAdmin() {
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

       public String checkValidUser()
        {
            if (userName.equals("admin") && password.equals("admin123")) {
                return "adminmenu";
            }else{
                return "failure";
            }
        }
    
    
}
