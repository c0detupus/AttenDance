/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package to;

/**
 *
 * @author c0detupus
 */
public class StudentTO {

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
    
    //temporarily added a constructor for hardcoded testing
    public StudentTO(String firstName,
            String lastName,
            String cellPhone,
            String avgAttendance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cellPhone = cellPhone;
        this.avgAttendance = avgAttendance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getAvgAttendance() {
        return avgAttendance;
    }

    public void setAvgAttendance(String avgAttendance) {
        this.avgAttendance = avgAttendance;
    }

}
