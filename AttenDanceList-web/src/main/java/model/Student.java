/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author c0detupus
 */
@ManagedBean(name = "studentBean")
@SessionScoped
public class Student
{

    private String firstName;
    private String lastName;
    private int socialSecurityNumber;
    private String eMail;
    private int cellPhone;
    private int phoneNumber;
    private String sex;
    private String address;
    private String city;
    private int zipCode;

    private String output = "asdasd";

    //******* SETTERS--->
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSocialSecurityNumber(int socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setCellPhone(int cellPhone) {
        this.cellPhone = cellPhone;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
    //<---SETTERS ******

    //******GETTERS--->
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public String geteMail() {
        return eMail;
    }

    public int getCellPhone() {
        return cellPhone;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getSex() {
        return sex;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public int getZipCode() {
        return zipCode;
    }
    //<---GETTERS******

    public void createStudent() {

        output = "it's ok";
        if(firstName.contains("123")) {
            output = "you have a nr";
        }

    }

    public String output() {

        return output;

    }
}
