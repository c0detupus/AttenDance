/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
    
    //hardcoded, replace with db queries or helper class
    public List<Course> getCourses(){
        courses = new ArrayList<>();
        courses.add(new Course("Java EE", "JEE", 100));
        courses.add(new Course("Java SE", "JSE", 100));
        courses.add(new Course("CSS", "CSS", 50));
        courses.add(new Course("JavaScript", "JS", 50));
        
        return courses;
    }
    
    public int getTotal(){
        total = courses.size();
        return total;
    }
}
