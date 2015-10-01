package model;

import afk.Services;
import afk.ServicesIntf;
import afk.to.CourseTO;
import helper.Populator;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author kajri.qu
 */
@ManagedBean(name = "courseBean")
@SessionScoped
public class Course implements Serializable {

    private String name;
    private String code;

    private String currentPoints;
    private Map<Integer, Integer> coursePointsMap;
    
    private Populator pop;
    
    @EJB
    ServicesIntf services;
    
    public Course(){
        
    }
    public Course(String name, String code, String points){
        this.name = name;
        this.code = code;
        this.currentPoints = points;
    }
    @PostConstruct
    public void init(){
        pop = new Populator();
        
        coursePointsMap = pop.populateCoursePointsMap();
        
    }
    
    public void submit(){
        services.getCourseService().createCourse(new CourseTO(this.name, this.code, this.currentPoints));
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
        return currentPoints;
    }

    public void setCurrentPoints(String currentPoints) {
        this.currentPoints = currentPoints;
    }

    public Map<Integer, Integer> getCoursePointsMap() {
        return coursePointsMap;
    }
}
