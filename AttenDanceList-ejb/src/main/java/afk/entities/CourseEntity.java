package afk.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<StudentEntity> students;

    public CourseEntity() {
        students = new ArrayList<>();
    }
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
    //<-----GETTERS
}
