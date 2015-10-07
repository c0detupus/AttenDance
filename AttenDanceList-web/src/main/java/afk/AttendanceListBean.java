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

    private List<Student> student;
    private List<Student> selectedStudent;
    private List<Course> courseList;

    private String selectedCourse;

    //String in Map is used to check First name, should be replaced to Long/Integer to check id/ssn
    private final Map<String, Boolean> selectedSSN = new HashMap<>();

    //hardcoded, replace with db queries or helper class
    public List<Student> getStudent() {

        //should fetch students depending on course
        
        return student;
    }

    public List<Course> getCourseList() {
        courseList = Helper.courseTOListConverter(services.getCourseService().getAll());
        return courseList;
    }

    public void getSelectedItems() {
        // Get selected items.
        selectedStudent = new ArrayList<>();
        for (Student s : student) {
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
