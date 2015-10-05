package model;

import afk.ServicesIntf;
import helper.Helper;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author kajri.qu
 */
@ManagedBean(name = "courseBean")
@ViewScoped
public class Course implements Serializable {

    private long id;

    private String name;
    private String code;
    private String points;

    private Map<Integer, Integer> coursePointsMap;

    private Helper pop;

    private long currentId;

    private String currentName;

    public void setCurrentName(String currentName) {
        this.currentName = currentName;
    }

    public void setCurrentCode(String currentCode) {
        this.currentCode = currentCode;
    }
    private String currentPoints;
    private String currentCode;

    private Course course;

    @EJB
    ServicesIntf services;

    @PostConstruct
    public void init() {

        Map<String, String> params = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
        currentId = Long.valueOf(params.get("id"));

        course = Helper.courseTOConverter(services.getCourseService().getCourse(currentId));

        System.out.println("Course init(): " + course.getName());
        coursePointsMap = Helper.populateCoursePointsMap();

    }

    public void submit() {
        services.getCourseService().createCourse(Helper.courseConverter(this));
    }

    public void save() {
        id = currentId;
        name = currentName;
        code = currentCode;
        points = currentPoints;
        System.out.println("Course id: " + id);
        System.out.println("Course name: " + name);
        System.out.println("Course code: " + code);
        System.out.println("Course points: " + points);
        
        
        services.getCourseService().updateCourse(Helper.courseConverter(this));

    }

    public void delete() {
        services.getCourseService().deleteCourse(currentId);
    }

    public String getCurrentCode() {
        currentCode = course.getCode();
        return currentCode;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public long getCurrentId() {
        return currentId;
    }

    public String getCurrentName() {
        currentName = course.getName();
        return currentName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCurrentPoints() {
        currentPoints = course.getPoints();
        return currentPoints;
    }

    public void setCurrentPoints(String currentPoints) {
        this.currentPoints = currentPoints;
    }

    public Map<Integer, Integer> getCoursePointsMap() {
        return coursePointsMap;
    }
}
