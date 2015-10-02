/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk;

import helper.Helper;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import model.Course;

/**
 *
 * @author valance
 */
@ManagedBean(name = "courseListBean")
public class CourseListBean implements Serializable {

    @EJB
    ServicesIntf services;
    
    private List<Course> courses;
    private int total;

    //hardcoded, replace with db queries or helper class
    public List<Course> getCourses() {
//        courses = new ArrayList<>();

        courses = Helper.courseTOListConverter(services.getCourseService().getAll());
//       
        return courses;
    }

    public int getTotal() {
        total = courses.size();
        return total;
    }
}
