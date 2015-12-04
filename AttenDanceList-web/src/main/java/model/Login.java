/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import afk.Services;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author valance
 */
@ManagedBean(name = "loginBean")
public class Login {

    private String name;
    private String password;
    
    @EJB
    private Services service;
    
    public void login(){
        
    }
    
    public void registerUser(){

    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
