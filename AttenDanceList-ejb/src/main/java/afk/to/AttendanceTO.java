/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.to;

import afk.entities.CourseEntity;
import afk.entities.StudentEntity;
import java.util.Date;

/**
 *
 * @author c0detupus
 */
public class AttendanceTO
{

    private long id;

//    private StudentEntity students;
//
//    private CourseEntity courses;

    private Date dateField;

    //SETTERS----->
    public void setId(long id) {
        this.id = id;
    }
//
//    public void setStudentEntity(StudentEntity studentEntity) {
//        this.students = studentEntity;
//    }
//
//    public void setCourseEntity(CourseEntity courseEntity) {
//        this.courses = courseEntity;
//    }

    public void setDateField(Date dateField) {
        this.dateField = dateField;
    }
    //<-----SETTERS

    //GETTERS----->
    public long getId() {
        return id;
    }

//    public StudentEntity getStudentEntity() {
//        return students;
//    }
//
//    public CourseEntity getCourseEntity() {
//        return courses;
//    }

    public Date getDateField() {
        return dateField;
    }
    //<-----GETTERS
}
