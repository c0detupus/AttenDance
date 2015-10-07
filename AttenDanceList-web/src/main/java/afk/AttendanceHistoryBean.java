/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk;

import helper.Helper;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Attendance;
import model.Course;

/**
 *
 * @author valance
 */
@ManagedBean(name = "attendanceHistoryBean")
@RequestScoped
public class AttendanceHistoryBean {

    private Date date;
    private String selectedCourse;
    private Course course;
    private List<Attendance> atten;

    @EJB
    private ServicesIntf services;

    public void renderList() {

        if (selectedCourse == null) {
            return;
        }
        course = Helper.courseTOConverter(services.getCourseService()
                .getCourse(Long.valueOf(selectedCourse), false), false);

        atten = Helper.attendanceTOListConverter(
                services.getAttendanceService().getAttendanceByDayAndCourse(
                        date, Helper.courseConverter(course, false)));

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
