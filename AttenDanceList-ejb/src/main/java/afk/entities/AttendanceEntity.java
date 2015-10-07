package afk.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
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

    @OneToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    @OneToOne
    @JoinColumn(name = "course_id")
    private CourseEntity course;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_field")
    private Date dateField;

    //The only place where "present" will be stored as a String
    //all other places will get stored as booleans
    //that is why setters and getters return boolean values
    @Column(name = "present")
    private String present;

    //SETTERS----->
    public void setId(long id) {
        this.id = id;
    }

    public void setStudent(StudentEntity students) {
        this.student = students;
    }

    public void setCourse(CourseEntity courseEntity) {
        this.course = courseEntity;
    }

    public void setDateField(Date dateField) {

        this.dateField = dateField;
    }

    public void setPresent(boolean present) {

        if(present == true) {
            this.present = "Y";
        } else {
            this.present = "N";
        }

    }
    //<------SETTERS

    //GETTERS----->
    public long getId() {
        return id;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public CourseEntity getCourse() {
        return course;
    }

    public Date getDateField() {
        return dateField;
    }

    public boolean getPresent() {
        return present.equals("Y");

    }
    //<------GETTERS

}
