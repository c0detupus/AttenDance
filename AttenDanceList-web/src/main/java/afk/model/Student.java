package afk.model;

import afk.services.ServicesIntf;
import afk.helper.Helper;
import afk.helper.Messages;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

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

    private List<Course> courses;

    private Student student;

    private List<Course> existingCourses;

    private List<String> selectedCourseIDs;

    private List<String> selectedCourseNames;

    public Student() {
        this.selectedCourseNames = new ArrayList<>();
    }

    @PostConstruct
    public void init() {

        Map<String, String> params = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();

        if(!params.isEmpty()) {
            id = Long.valueOf(params.get("id"));
            student = Helper.studentTOConverter(services.getStudentService()
                    .getStudent(id, true), true);

            courses = student.getCourses();
            selectedCourseIDs = new ArrayList<>();
            for(Course c : courses) {
                String s = String.valueOf(c.getId());
                selectedCourseIDs.add(s);
                System.out.println("Init() s : " + s);
            }

            initialize();
        }

        existingCourses = Helper.courseTOListConverter(services
                .getCourseService().getAll(), false);

        if(selectedCourseIDs != null) {
            updateSelectedCoursePanel();

        }
    }

    public void updateSelectedCoursePanel() {

        List<String> nameHolder = new ArrayList<>();

        for(String s : selectedCourseIDs) {

            for(Course currentCourse : existingCourses) {

                if(currentCourse.getId() == Long.parseLong(s)) {

                    nameHolder.add(currentCourse.getName());
                }
            }
        }
        selectedCourseNames = nameHolder;

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
        courses = new ArrayList<>();
        Course course;
        for(String s : selectedCourseIDs) {
            course = Helper.courseTOConverter(services.getCourseService()
                    .getCourse(Long.valueOf(s), false), false);
            courses.add(course);
        }

        int i = services.getStudentService().createStudent(Helper
                .studentConverter(this, true));
        Messages.showMessage(i);
        clear();
    }

    public void update() {
        courses = new ArrayList<>();
        Course course;
        for(String s : selectedCourseIDs) {
            course = Helper.courseTOConverter(services.getCourseService()
                    .getCourse(Long.valueOf(s), false), false);
            courses.add(course);
        }
        int i = services.getStudentService().updateStudent(Helper
                .studentConverter(this, true));
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

    public List<String> getSelectedCourseIDs() {
        return selectedCourseIDs;
    }

    public void setSelectedCourseIDs(List<String> selectedCourseIDs) {
        this.selectedCourseIDs = selectedCourseIDs;
    }

    public List<Course> getExistingCourses() {
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

    public void setSelectedCourseNames(List<String> selectedCourseNames) {
        this.selectedCourseNames = selectedCourseNames;
    }

    //<---SETTERS 
    
    //GETTERS--->
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

    public List<String> getSelectedCourseNames() {
        return selectedCourseNames;
    }
    //<---GETTERS

}
