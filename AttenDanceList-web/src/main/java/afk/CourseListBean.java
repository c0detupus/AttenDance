/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import model.Courses;

/**
 *
 * @author valance
 */
@ManagedBean(name="courseListBean")
public class CourseListBean {
    
    private List<Courses> course;
    private int total;
    
    //hardcoded, replace with db queries or helper class
    public List<Courses> getCourses(){
        course = new ArrayList<>();
        course.add(new Courses("Java EE", "JEE", 100));
        course.add(new Courses("Java SE", "JSE", 100));
        course.add(new Courses("CSS", "CSS", 50));
        course.add(new Courses("JavaScript", "JS", 50));
        
        return course;
    }
    
    public int getTotal(){
        total = course.size();
        return total;
    }
}
