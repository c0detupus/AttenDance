/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk;

import helper.Populator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import model.Course;

/**
 *
 * @author valance
 */
@ManagedBean(name="courseListBean")
public class CourseListBean implements Serializable {
    
    private List<Course> courses;
    private int total;
    
    private Populator pop;
    
    @EJB
    ServicesIntf services;
    
    //hardcoded, replace with db queries or helper class
    public List<Course> getCourses(){
//        courses = new ArrayList<>();
        
       courses = Populator.courseTOconverter(services.getCourseService().getAll());
//       
        return courses;
    }
    
    public int getTotal(){
        total = courses.size();
        return total;
    }
}
