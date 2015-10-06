/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author c0detupus
 */
@Entity
@Table(name = "Course")
public class CourseEntity implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "points")
    private String points;


    @OneToOne
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacher;

    @ManyToMany
    @JoinTable(name = "course_student_JoinTable",
               joinColumns = @JoinColumn(name = "course_id"),
               inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<StudentEntity> students;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "id")
//    private TeacherEntity teacher;


    //SETTERS----->
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPoints(String points) {
        this.points = points;
    }


    public void setTeacher(TeacherEntity teacher) {
        this.teacher = teacher;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }
//
//    public void setTeacher(TeacherEntity teacher) {
//        this.teacher = teacher;
//    }

    //<-----SETTERS

    //GETTERS----->
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getPoints() {
        return points;
    }

    
    public TeacherEntity getTeacher() {
        return teacher;
    }


    public List<StudentEntity> getStudents() {
        return students;
    }
//
//    public TeacherEntity getTeacher() {
//        return teacher;
//    }

    //<-----GETTERS

}
