/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author c0detupus
 */
@ManagedBean(name = "statsBean")
@SessionScoped
public class StatsBean {
    
    private List coursesList;
    private String currentCourse;

    public String getCurrentCourse() {
        return currentCourse;
    }

    public void setCurrentCourse(String currentCourse) {
        this.currentCourse = currentCourse;
    }

    public List getCoursesList() {
        //will populate the list depending on database
        //hardcoded for now
        this.coursesList.add(new SelectItem("Java EE","Java EE"));
        this.coursesList.add(new SelectItem("JavaScript","JavaScript"));
        this.coursesList.add(new SelectItem("CSS","CSS"));
        return coursesList;
    }

//    public void setCoursesList(List coursesList) {
//        this.coursesList = coursesList;
//    }
//    
}
