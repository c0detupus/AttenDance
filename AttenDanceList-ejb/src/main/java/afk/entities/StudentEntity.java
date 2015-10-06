package afk.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author c0detupus
 */
@Entity
@Table(name = "Student")
public class StudentEntity implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "ssn")
    private String socialSecurityNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "cellphone")
    private String cellPhone;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "sex")
    private String sex;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "avg_attendance")
    private String avgAttendance;
//    @ManyToMany(targetEntity = afk.entities.CourseEntity.class)
//    private List<CourseEntity> courses;

//    @ManyToMany(targetEntity = afk.entities.TeacherEntity.class)
//    private List<TeacherEntity> teachers;

    //SETTERS----->
    public void setId(long id) {
        this.id = id;
    }

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

//    public void setCourses(List<CourseEntity> courses) {
//        this.courses = courses;
//    }
//
//    public void setTeachers(List<TeacherEntity> teachers) {
//        this.teachers = teachers;
//    }
    //<-----SETTERS

    //GETTERS----->
    public long getId() {
        return id;
    }

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

//    public List<CourseEntity> getCourses() {
//        return courses;
//    }
//
//    public List<TeacherEntity> getTeachers() {
//        return teachers;
//    }
    //<-----GETTERS
}
