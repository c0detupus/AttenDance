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
 * @author c0detupus
 */
@ManagedBean(name = "studentBean")
@ViewScoped
public class Student implements Serializable {

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


    private List<Course> courses;


    private List<Teacher> teachers;



    private Student student;
    private List<Course> existingCourses;

    private List<Course> selectedCourses;

    @PostConstruct
    public void init() {

        Map<String, String> params = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
        if (!params.isEmpty()) {
            id = Long.valueOf(params.get("id"));
            student = Helper.studentTOConverter(services.getStudentService()
                    .getStudent(id));
            initialize();
        }

        existingCourses = Helper.courseTOListConverter(services.getCourseService().getAll());
        System.out.println("STUDENT EXISTING_COURSES" + existingCourses);
    }

    private void initialize() {
        firstName = student.getFirstName();
        lastName = student.getLastName();
        socialSecurityNumber = student.getSocialSecurityNumber();
        email = student.getEmail();
        cellPhone = student.getCellPhone();
        phoneNumber = student.getPhoneNumber();
        sex = student.getSex();
        address = student.getAddress();
        city = student.getCity();
        zipCode = student.getZipCode();
        avgAttendance = student.getAvgAttendance();
    }

    public void add() {
        
        System.out.println("SELECTED COURSES BEFORE" + selectedCourses);
        setCourses(selectedCourses);
        System.out.println("SELECTED COURSES AFTER" + courses);
        
        int i = services.getStudentService().createStudent(Helper
                .studentConverter(this));
        Messages.showMessage(i);
        clear();
    }

    public void update() {
        int i = services.getStudentService().updateStudent(Helper
                .studentConverter(this));
        Messages.showMessage(i);
    }

    public void delete() {
        int i = services.getStudentService().deleteStudent(id);
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
        avgAttendance = null;
    }


    public List<Course> getSelectedCourses() {
        return selectedCourses;
    }

    public void setSelectedCourses(List<Course> selectedCourses) {
        this.selectedCourses = selectedCourses;
    }

    public List<Course> getCourseList() {
        return existingCourses;
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

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
//
//    public void setTeachers(List<Teacher> teachers) {
//        this.teachers = teachers;
//    }
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

    public List<Course> getCourses() {
        return courses;
    }
//
//    public List<Teacher> getTeachers() {
//        return teachers;
//    }
    //<---GETTERS******

    //******VALIDATORS--->
    public void validateLetters(FacesContext context,
            UIComponent toValidate,
            Object value) throws ValidatorException {

        String str = (String) value;

        if (!onlyLettersSC(str)) {
            throw new ValidatorException(new FacesMessage("Can only have letters"));
        }
    }

    public void validateEmail(FacesContext context,
            UIComponent toValidate,
            Object value) throws ValidatorException {
        String str = (String) value;
        if (-1 == value.toString().indexOf("@")) {
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

        if (!onlyNumbers(cleaned)) {
            throw new ValidatorException(
                    new FacesMessage("Only numbers preffered format YYMMDDXXXX or YYMMDD-XXXX"));
        }

        if (cleaned.length() != 10) {

            throw new ValidatorException(new FacesMessage("Use format YYMMDDXXXX or YYMMDD-XXXX"));
        }

    }

    public void validatePhoneNumbers(FacesContext context,
            UIComponent toValidate,
            Object value) throws ValidatorException {

        String str = (String) value;

        String cleaned = str.replaceFirst("\\s", "");

        if (!onlyNumbers(str)) {
            throw new ValidatorException(
                    new FacesMessage("Only numbers"));
        }

    }

    public void validateZipCode(FacesContext context,
            UIComponent toValidate,
            Object value) throws ValidatorException {

        String str = (String) value;
        if (!onlyNumbers(str)) {
            throw new ValidatorException(
                    new FacesMessage("Only numbers"));
        }

        if (str.length() != 10) {
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
