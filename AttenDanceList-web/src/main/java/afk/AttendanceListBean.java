package afk;

import helper.Helper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import model.Course;
import model.Student;

/**
 *
 * @author valance
 */
@ManagedBean(name = "attendanceListBean")
public class AttendanceListBean implements Serializable {

    @EJB
    private ServicesIntf services;

    private List<Student> students;
    private List<Student> selectedStudent;
    private List<Course> courseList;

    private String selectedCourse;

    //String in Map is used to check First name, should be replaced to Long/Integer to check id/ssn
    private final Map<String, Boolean> selectedSSN = new HashMap<>();

    //hardcoded, replace with db queries or helper class
    public List<Student> getStudents() {
        return students;
    }

    public void renderList() {
        try {
            Course course;
            course = Helper.courseTOConverter(services.getCourseService().getCourse(Long.valueOf(selectedCourse), true), true);
            students = course.getStudents();
        } catch (NullPointerException e) {

        }
    }

    public List<Course> getCourseList() {

        courseList = Helper.courseTOListConverter(services.getCourseService().getAll(), false);
        return courseList;
    }

    public void getSelectedItems() {
        // Get selected items.
        selectedStudent = new ArrayList<>();
        for (Student s : students) {
            //replace firstname to id/ssn
            if (selectedSSN.get(s.getFirstName())) {
                selectedStudent.add(s);
            }
        }
        //do things with selectedStudent??
    }

    public void submit() {
        getSelectedItems();
        for (Student s : selectedStudent) {
            System.out.println("selectedStudent: " + s.getFirstName());
        }
        //do things with selectedStudent???
    }

    public Map<String, Boolean> getSelectedSSN() {
        return selectedSSN;
    }

    public String getSelectedCourse() {
        return selectedCourse;
    }

    public void setSelectedCourse(String selectedCourse) {
        this.selectedCourse = selectedCourse;
    }
}
