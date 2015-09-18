package model;

import helper.Populator;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author kajri.qu
 */
@ManagedBean(name = "courseBean")
@SessionScoped
public class Course {

    private String name;
    private String code;

    private int currentPoints;
    private Map<Integer, Integer> coursePointsMap;
    
    private Populator pop;
    
    public Course(){
        
    }
    public Course(String name, String code, int points){
        this.name = name;
        this.code = code;
        this.currentPoints = points;
    }
    @PostConstruct
    public void init(){
        pop = new Populator();
        
        coursePointsMap = pop.populateCoursePointsMap();
        
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
        public int getCurrentPoints() {
        return currentPoints;
    }

    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    }

    public Map<Integer, Integer> getCoursePointsMap() {
        return coursePointsMap;
    }
}
