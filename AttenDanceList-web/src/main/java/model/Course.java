package model;

import afk.Services;
import afk.ServicesIntf;
import afk.to.CourseTO;
import helper.Helper;
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
    
    private Helper pop;
    
    @EJB
    ServicesIntf services;
    
    @PostConstruct
    public void init(){
        pop = new Helper();
        
        coursePointsMap = pop.populateCoursePointsMap();
        
    }
    
    public void submit(){
        services.getCourseService().createCourse(Helper.courseConverter(this));
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
