package afk;

import afk.to.StudentTO;
import helper.Helper;
import helper.Messages;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Attendance;
import model.Course;
import model.Student;

/**
 *
 * @author valance
 */
@ManagedBean(name = "attendanceListBean")
@ViewScoped
public class AttendanceListBean implements Serializable
{

    @EJB
    private ServicesIntf services;

    private List<Student> students;
    private List<Student> selectedStudents;

    private List<Course> courseList;

    private String selectedCourse;

    private Course course;


    public void renderList() {
        if(selectedCourse == null) {
            return;
        }
        List<StudentTO> fool = services.getCourseService()
                .getAllStudentsInCourse(Long.valueOf(selectedCourse));

        students = Helper.studentTOListConverter(fool, false);
       
        course = Helper.courseTOConverter(services.getCourseService()
                .getCourse(Long.valueOf(selectedCourse), true), true);

    }

    public List<Course> getCourseList() {

        courseList = Helper.courseTOListConverter(services.getCourseService()
                .getAll(), false);
        return courseList;
    }

    public void submit() {
        List<Attendance> attendancelist = new ArrayList<>();

        Date d = new Date();

        System.out.println(course.getName());

        for(Student s : students) {
            boolean check = false;
            for(Student selected : selectedStudents) {

                if(s.getId() == selected.getId()) {
                    check = true;
                    break;
                }
            }
            if(check) {

                Attendance attendance = new Attendance();
                attendance.setStudent(s);
                attendance.setCourse(course);
                attendance.setDateField(d);
                attendance.setPresent(true);
                attendancelist.add(attendance);

            } else {
                Attendance attendance = new Attendance();
                attendance.setStudent(s);
                attendance.setCourse(course);
                attendance.setDateField(d);
                attendance.setPresent(false);
                attendancelist.add(attendance);
            }

        }

        int i = services.getAttendanceService().createAttendance(Helper
                .attendanceListConverter(attendancelist));

        Messages.showMessage(i);
    }
    
    public List<Student> getStudents() {
        return students;
    }

    public List<Student> getSelectedStudents() {
        return selectedStudents;
    }

    public void setSelectedStudents(List<Student> selectedStudents) {
        this.selectedStudents = selectedStudents;
    }

    public String getSelectedCourse() {
        return selectedCourse;
    }

    public void setSelectedCourse(String selectedCourse) {
        this.selectedCourse = selectedCourse;
    }
}
