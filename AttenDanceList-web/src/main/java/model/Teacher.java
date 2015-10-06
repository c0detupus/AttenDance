/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import afk.ServicesIntf;
import helper.Helper;
import helper.Messages;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author valance
 */
@ManagedBean(name = "teacherBean")
@ViewScoped
public class Teacher implements Serializable
{

    @EJB
    private ServicesIntf services;

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
            zipCode;

    private List<Student> students;
    private Course course;

    private Teacher teacher;

    @PostConstruct
    public void init() {

        Map<String, String> params = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
        if(!params.isEmpty()) {
            id = Long.valueOf(params.get("id"));
            System.out.println("Teacher id " + id);
            teacher = Helper.teacherTOConverter(services.getTeacherService()
                    .getTeacher(id));
            initialize();
        }
    }

    private void initialize() {
        firstName = teacher.getFirstName();
        lastName = teacher.getLastName();
        socialSecurityNumber = teacher.getSocialSecurityNumber();
        email = teacher.getEmail();
        cellPhone = teacher.getCellPhone();
        phoneNumber = teacher.getPhoneNumber();
        sex = teacher.getSex();
        address = teacher.getAddress();
        city = teacher.getCity();
        zipCode = teacher.getZipCode();
    }

    public void add() {
        int i = services.getTeacherService().createTeacher(Helper
                .teacherConverter(this));
        Messages.showMessage(i);
        clear();
    }

    public void update() {
        System.out.println("Teacher update()");
        int i = services.getTeacherService().updateTeacher(Helper
                .teacherConverter(this));
        Messages.showMessage(i);
    }

    public void delete() {
        int i = services.getTeacherService().deleteTeacher(id);
        Messages.showMessage(i);
    }

    public void clear() {
        firstName = null;
        lastName = null;
        socialSecurityNumber = null;
        email = null;
        cellPhone = null;
        phoneNumber = null;
        sex = null;
        address = null;
        city = null;
        zipCode = null;
    }

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
        if(-1 == value.toString().indexOf("@")) {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private boolean onlyNumbers(String str) {
        return str.matches("[0-9]+");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
