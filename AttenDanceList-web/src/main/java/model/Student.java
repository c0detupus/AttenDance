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

/**
 *
 * @author c0detupus
 */
@ManagedBean(name = "studentBean")
@SessionScoped
public class Student
{

    private String firstName,
            lastName,
            socialSecurityNumber,
            email,
            cellPhone,
            phoneNumber,
            sex,
            address,
            city,
            zipCode;

    public Student() {

    }

    public Student(String fn, String ln) {
        this.firstName = fn;
        this.lastName = ln;
    }

    //******* SETTERS--->
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public void setPhoneNumber(String phoneNumber) {
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

    public void setZipCode(String zipCode) {
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

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public String getPhoneNumber() {
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

    public String getZipCode() {
        return zipCode;
    }
    //<---GETTERS******

    //******VALIDATORS--->
    public void validateLetters(FacesContext context,
                                UIComponent toValidate,
                                Object value) throws ValidatorException {

        String str = (String) value;

        if(!onlyLettersSC(str)) {
            throw new ValidatorException(new FacesMessage("Can only have letters"));
        }
    }

    public void validateEmail(FacesContext context,
                              UIComponent toValidate,
                              Object value) throws ValidatorException {
        String str = (String) value;
        if(-1 == value.toString().indexOf("@") && !onlyLetters(str)) {
            FacesMessage message = new FacesMessage("Invalid email address");
            throw new ValidatorException(message);
        }
    }

    public void validateSSN(FacesContext context,
                            UIComponent toValidate,
                            Object value) throws ValidatorException {
        String str = (String) value;

        FacesMessage message = new FacesMessage();

        //Replaces first ocurrence of '-' not all occurences cause 
        //ssn can be erroneously bli written with more than one '-'
        String cleaned = str.replaceFirst("[-]", "");

        if(!onlyNumbers(cleaned)) {
            throw new ValidatorException(
                    new FacesMessage("Only numbers preffered format YYMMDDXXXX or YYMMDD-XXXX"));
        }

        if(cleaned.length() != 10) {

            throw new ValidatorException(new FacesMessage("Use format YYMMDDXXXX or YYMMDD-XXXX"));
        }

        throw new ValidatorException(message);

    }
    //<---VALIDATORS*****

    //*****PRIVATE METHODS--->
    private boolean onlyLetters(String str) {

        return str.matches("[a-zA-Z]+");

    }

    //Handles regex for letters only but with special characters included
    private boolean onlyLettersSC(String str) {

        return str.matches("[a-zA-ZåäöÅÄÖ]+");

    }

    private boolean onlyNumbers(String str) {
        return str.matches("[0-9]+");
    }
    //<---PRIVATE METHODS*****

}
