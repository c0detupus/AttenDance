package model;

import afk.ServicesIntf;
import helper.Helper;
import helper.Messages;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author kajri.qu
 */
@ManagedBean(name = "courseBean")
@ViewScoped
public class Course implements Serializable
{

    private long id;

    private String name;
    private String code;
    private String points;

    private Map<Integer, Integer> coursePointsMap;

    private Course course;

    @EJB
    private ServicesIntf services;

    @PostConstruct
    public void init() {

        Map<String, String> params = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
        if(!params.isEmpty()) {
            id = Long.valueOf(params.get("id"));
            course = Helper.courseTOConverter(services.getCourseService()
                    .getCourse(id));
            initialize();
        }

        coursePointsMap = Helper.populateCoursePointsMap();
    }

    public void initialize() {
        name = course.getName();
        code = course.getCode();
        points = course.getPoints();
    }

    public void add() {

        int i = services.getCourseService().createCourse(Helper
                .courseConverter(this));
        Messages.showMessage(i);
        clear();
    }

    public void update() {
        int i = services.getCourseService().updateCourse(Helper
                .courseConverter(this));
        Messages.showMessage(i);
    }

    public void delete() {
        int i = services.getCourseService().deleteCourse(id);
        Messages.showMessage(i);
    }

    public void clear() {
        name = null;
        code = null;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
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

    public Map<Integer, Integer> getCoursePointsMap() {
        return coursePointsMap;
    }
}
