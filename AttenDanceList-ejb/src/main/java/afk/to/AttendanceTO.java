/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.to;

import java.util.Date;

/**
 *
 * @author c0detupus
 */
public class AttendanceTO
{

    private long id;

    private StudentTO students;

    private CourseTO courses;

    private Date dateField;

    private boolean present;

    //SETTERS----->
    public void setId(long id) {
        this.id = id;
    }

    public void setStudent(StudentTO studentEntity) {
        this.students = studentEntity;
    }

    public void setCourse(CourseTO courseEntity) {
        this.courses = courseEntity;
    }

    public void setDateField(Date dateField) {
        this.dateField = dateField;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }
    //<-----SETTERS

    //GETTERS----->
    public long getId() {
        return id;
    }

    public StudentTO getStudent() {
        return students;
    }

    public CourseTO getCourse() {
        return courses;
    }

    public Date getDateField() {
        return dateField;
    }

    public boolean getPresent() {
        return present;
    }
    //<-----GETTERS
}
