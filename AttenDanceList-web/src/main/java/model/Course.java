package model;

import afk.ServicesIntf;
import helper.Helper;
import helper.Messages;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author kajri.qu
 */
@ManagedBean(name = "courseBean")
@ViewScoped
public class Course implements Serializable {

    private long id;

    private String name;
    private String code;
    private String points;

    private List<Student> students;
    private List<Teacher> teachersList;

    public List<Teacher> getTeachersList() {
        return teachersList;
    }

    private String teacherId;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }


    private List<Teacher> selectedTeacher;

    public List<Teacher> getSelectedTeacher() {
        return selectedTeacher;
    }

    public void setSelectedTeacher(List<Teacher> selectedTeacher) {
        this.selectedTeacher = selectedTeacher;
    }

    private Teacher teacher;
    private Map<Integer, Integer> coursePointsMap;

    private Course course;

    @EJB
    private ServicesIntf services;

    @PostConstruct
    public void init() {
        Map<String, String> params = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
        if (!params.isEmpty()) {
            id = Long.valueOf(params.get("id"));
            course = Helper.courseTOConverter(services.getCourseService()
                    .getCourse(id, false), false);
            initialize();
        }

        teachersList = Helper.teacherTOListConverter(services.getTeacherService().getAll());
        coursePointsMap = Helper.populateCoursePointsMap();
    }

    public void initialize() {
        name = course.getName();
        code = course.getCode();
        points = course.getPoints();
    }

    public void test() {
        System.out.println("Course teacher: " + teacherId);
    }

    public void add() {
        long tId = Long.valueOf(teacherId);
        teacher = Helper.teacherTOConverter(services.getTeacherService().getTeacher(tId));
        try {
            int i = services.getCourseService().createCourse(Helper
                    .courseConverter(this, false));
            Messages.showMessage(i);
            clear();
        } catch (Exception e) {
        }

    }

    public void update() {
        long tId = Long.valueOf(teacherId);
        teacher = Helper.teacherTOConverter(services.getTeacherService().getTeacher(tId));
        int i = services.getCourseService().updateCourse(Helper
                .courseConverter(this, false));
        Messages.showMessage(i);
    }

    public void delete() {
        int i = services.getCourseService().deleteCourse(id);
        Messages.showMessage(i);
    }

    public void clear() {
        name = null;
        code = null;
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

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setTeachersList(List<Teacher> teachersList) {
        this.teachersList = teachersList;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setCoursePointsMap(Map<Integer, Integer> coursePointsMap) {
        this.coursePointsMap = coursePointsMap;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setServices(ServicesIntf services) {
        this.services = services;
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

    public List<Student> getStudents() {
        return students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Map<Integer, Integer> getCoursePointsMap() {
        return coursePointsMap;
    }

    public Course getCourse() {
        return course;
    }

    public ServicesIntf getServices() {
        return services;
    }
    //<-----GETTERS
    
    

}
