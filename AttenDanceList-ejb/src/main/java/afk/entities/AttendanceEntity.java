package afk.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private StudentEntity students;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private CourseEntity courses;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_field")
    private Date dateField;

    //SETTERS----->
    public void setId(long id) {
        this.id = id;
    }

    public void setStudents(StudentEntity students) {
        this.students = students;
    }

    public void setCourseEntity(CourseEntity courseEntity) {
        this.courses = courseEntity;
    }

    public void setDateField(Date dateField) {

        this.dateField = dateField;
    }
    //<------SETTERS

    //GETTERS----->
    public long getId() {
        return id;
    }

    public StudentEntity getStudents() {
        return students;
    }

    public CourseEntity getCourseEntity() {
        return courses;
    }

    public Date getDateField() {
        return dateField;
    }
    //<------GETTERS

}
