/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.history;

import afk.services.ServicesIntf;
import afk.helper.Helper;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import afk.model.Attendance;
import afk.model.Course;

/**
 *
 * @author valance
 */
@ManagedBean(name = "attendanceHistoryBean")
@ViewScoped
public class AttendanceHistoryBean implements Serializable{

    private Date date;
    private String selectedCourse;
    private Course course;
    private List<Attendance> atten;
    private List<Course> courseList;

    @EJB
    private ServicesIntf services;

    public void renderList() {
        if (selectedCourse == null) {
            return;
        }
        if (date == null){
            return;
        }
        course = Helper.courseTOConverter(services.getCourseService()
                .getCourse(Long.valueOf(selectedCourse), false), false);

        atten = Helper.attendanceTOListConverter(
                services.getAttendanceService().getAttendanceByDayAndCourse(
                        date, Helper.courseConverter(course, false)));

    }

    public List<Course> getCourseList() {
        courseList = Helper.courseTOListConverter(services.getCourseService()
                .getAll(), false);
        return courseList;
    }

    public String getSelectedCourse() {
        return selectedCourse;
    }

    public void setSelectedCourse(String selectedCourse) {
        this.selectedCourse = selectedCourse;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Attendance> getAtten() {
        return atten;
    }
}
