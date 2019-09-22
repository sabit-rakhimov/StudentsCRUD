package com.example;

import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Created by S.Rakhimov
 */


@ManagedBean
@SessionScoped
public class UserLoginView {

    private String userName;
    private String password;

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

    public String validateUserLogin() {
        String navResult = "";
        System.out.println("Entered Username is = " + userName + ", password is = " + password);
        if (userName.equalsIgnoreCase("admin") && password.equals("admin")) {
            navResult = "success";
        } else {
            navResult = "failure";
        }
        return navResult;
    }
}