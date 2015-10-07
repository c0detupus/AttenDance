/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author c0detupus
 */
public class Attendance
{

    private long id;

    private Student students;

    private Course courses;

    private Date dateField;

    private boolean present;

    //SETTERS----->
    public void setId(long id) {
        this.id = id;
    }

    public void setStudent(Student student) {
        this.students = student;
    }

    public void setCourse(Course course) {
        this.courses = course;
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

    public Student getStudent() {
        return students;
    }

    public Course getCourse() {
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
