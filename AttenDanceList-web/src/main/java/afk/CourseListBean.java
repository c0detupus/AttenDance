/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk;

import helper.Helper;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Course;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author valance
 */
@ManagedBean(name = "courseListBean")
public class CourseListBean implements Serializable {

    @EJB
    private ServicesIntf services;

    private List<Course> courses;
    
    private Course course;
    
    private int total;

    public List<Course> getCourses() {
        courses = Helper.courseTOListConverter(services.getCourseService().getAll());

        return courses;
    }

    public void onRowSelect(SelectEvent event) throws IOException {
        course = (Course) event.getObject();
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("courseView.xhtml?id=" + course.getId());
    }

    public int getTotal() {
        total = courses.size();
        return total;
    }
}
