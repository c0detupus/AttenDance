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
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author c0detupus
 */
@ManagedBean(name = "studentBean")
@SessionScoped
public class Student
{

    @NotNull
    @Pattern(regexp = "^[A-z]+$")
    private String firstName,
            lastName,
            address,
            city,
            sex;
    @NotNull
    @Digits(integer = 10, fraction = 0)
    private int socialSecurityNumber;

    @Email
    @NotNull
    private String email;
    @NotNull
    @Digits(integer = 16, fraction = 0)
    private int cellPhone, phoneNumber;

    @NotNull
    @Digits(integer = 10, fraction = 0)
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

    public void validateEmail(FacesContext context,
                              UIComponent toValidate,
                              Object value) throws ValidatorException {
        String emailStr = (String) value;
        if(-1 == emailStr.indexOf("@")) {
            FacesMessage message = new FacesMessage("Invalid email address");
            throw new ValidatorException(message);
        }
    }

}
