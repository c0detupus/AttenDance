/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author c0detupus
 */
@ManagedBean(name = "studentBean")
@SessionScoped
public class Student
{

    private String firstName,
            lastName;
    private int socialSecurityNumber;

    @Email
    private String email;
    private int cellPhone;
    private int phoneNumber;
    private String sex;

    private String address,
            city;
    private int zipCode;

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

    public void setEmail(String email) {
        this.email = email;
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

    public String getEmail() {
        return email;
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

    public void validateEmailvalidateEmail(FacesContext context,
                                           UIComponent toValidate, Object value) {

        String email = this.email;

        if(!email.contains("@")) {
            FacesMessage message = new FacesMessage("Invalid emailaddress");
            throw new ValidatorException(message);
        }

    }

}
