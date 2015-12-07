package afk.model;

import afk.helper.DefaultUserRoles;
import afk.services.ServicesIntf;
import afk.helper.Helper;
import afk.helper.Messages;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

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
            zipCode,
            username,
            password,
            userType;

    private Teacher teacher;

    @PostConstruct
    public void init() {

        Map<String, String> params = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
        if(!params.isEmpty()) {
            id = Long.valueOf(params.get("id"));
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

    //SETTERS----->
    public void setServices(ServicesIntf services) {
        this.services = services;
    }

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

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setPassword(String password) {
        try {
            this.password = Helper.hashString(password);
        } catch(NoSuchAlgorithmException ex) {
            Logger.getLogger(Teacher.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    //<-----SETTERS
    
    
    //GETTERS----->
    public ServicesIntf getServices() {
        return services;
    }

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

    public Teacher getTeacher() {
        return teacher;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return DefaultUserRoles.TEACHER.getRole();
    }
    
    public String getUsername() {

        
        String newLast;

        if(lastName.length() <= 3) {
            newLast = lastName;
        } else {
            newLast = lastName.substring(0, 3);
        }

        this.username = firstName + "." + newLast;

        
        return username.toLowerCase();
    }

    //<-----GETTERS
}
