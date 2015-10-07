package afk;

import helper.Helper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Course;
import model.Student;

/**
 *
 * @author valance
 */
@ManagedBean(name = "attendanceListBean")
@ViewScoped
public class AttendanceListBean implements Serializable {

    @EJB
    private ServicesIntf services;

    private List<Student> students;
    private List<Student> selectedStudent;

    private List<Course> courseList;

    private String selectedCourse;

    //String in Map is used to check First name, should be replaced to Long/Integer to check id/ssn
    private final Map<String, Boolean> selectedSSN = new HashMap<>();


    @PostConstruct
    public void init() {
//        selectedStudent = new ArrayList<>();

    }

    public List<Student> getStudents() {
        if (selectedCourse != null) {
            renderList();
        }
        return students;
    }

    public void renderList() {
        Course course;
        course = Helper.courseTOConverter(services.getCourseService().getCourse(Long.valueOf(selectedCourse), true), true);
        students = course.getStudents();
    }

    public List<Course> getCourseList() {

        courseList = Helper.courseTOListConverter(services.getCourseService().getAll(), false);
        return courseList;
    }
    
    //ignore for now
    public void getSelectedItems() {
        // Get selected items.
        renderList();
        selectedStudent = new ArrayList<>();
        System.out.println("Att selectedItems: " + students);
        for (Student s : students) {
            //replace firstname to id/ssn
            System.out.println("selectedItems map: " + selectedSSN.toString());
            if (selectedSSN.get(s.getFirstName())) {
                System.out.println("selectedItems id: " + s.getId());
                System.out.println("selectedItems name: " + s.getFirstName());
                selectedStudent.add(s);
            }
        }
        //do things with selectedStudent??
    }

    public void submit() {

        System.out.println("Submit called()");
//        getSelectedItems();
//        for (Student s : selectedStudent) {
//            System.out.println("selectedStudent: " + s.getFirstName());
//        }
        //do things with selectedStudent???
        System.out.println("selected Student: " + selectedStudent);
        System.out.println("selected Student size: " + selectedStudent.size());
//        System.out.println("selected datatable: " + datatable);
    }

    public List<Student> getSelectedStudent() {
        return selectedStudent;
    }

    public void setSelectedStudent(List<Student> selectedStudent) {
        this.selectedStudent = selectedStudent;
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
