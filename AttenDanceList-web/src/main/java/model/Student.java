/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import afk.ServicesIntf;
import helper.Helper;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author c0detupus
 */
@ManagedBean(name = "studentBean")
@ViewScoped
public class Student implements Serializable
{
    @EJB
    ServicesIntf services;
    
    private long id;

    private String firstName,
            lastName,
            socialSecurityNumber,
            email,
            cellPhone,
            phoneNumber,
            sex,
            address,
            city,
            zipCode,
            avgAttendance;
    
    private String currentFirstName,
            currentLastName,
            currentsocialSecurityNumber,
            currentEmail;
    
    public void submit() {
        services.getStudentService().createStudent(Helper.studentConverter(this));
    }
    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public void setAvgAttendance(String avgAttendance) {
        this.avgAttendance = avgAttendance;
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

    public String getAvgAttendance() {
        return avgAttendance;
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

    }

    public void validatePhoneNumbers(FacesContext context,
                                     UIComponent toValidate,
                                     Object value) throws ValidatorException {

        String str = (String) value;

        String cleaned = str.replaceFirst("\\s", "");

        if(!onlyNumbers(str)) {
            throw new ValidatorException(
                    new FacesMessage("Only numbers"));
        }

    }

    public void validateZipCode(FacesContext context,
                                UIComponent toValidate,
                                Object value) throws ValidatorException {

        String str = (String) value;
        if(!onlyNumbers(str)) {
            throw new ValidatorException(
                    new FacesMessage("Only numbers"));
        }

        if(str.length() != 10) {
            throw new ValidatorException(
                    new FacesMessage("Invalid postal code"));

        }

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
