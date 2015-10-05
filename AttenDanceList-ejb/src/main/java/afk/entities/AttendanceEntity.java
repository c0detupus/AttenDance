/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author c0detupus
 */
@Entity
@Table(name = "attendance")
public class AttendanceEntity implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "attendance_id")
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private StudentEntity studentEntity;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private CourseEntity courseEntity;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_field")
    private Date date_field;

    //SETTERS----->
    public void setId(long id) {
        this.id = id;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    public void setCourseEntity(CourseEntity courseEntity) {
        this.courseEntity = courseEntity;
    }

    public void setDate_field() {

        this.date_field = new Date();
    }
    //<------SETTERS

    //GETTERS----->
    public long getId() {
        return id;
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public CourseEntity getCourseEntity() {
        return courseEntity;
    }

    public Date getDate_field() {
        return date_field;
    }
    //<------GETTERS

}
