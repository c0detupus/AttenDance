package afk;

import helper.Helper;
import helper.Messages;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
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

    //String in Map is used to check First name, should be replaced to Long/Integer to check id/ssn
    private final Map<String, Boolean> selectedSSN = new HashMap<>();

    @PostConstruct
    public void init() {
//        selectedStudents = new ArrayList<>();

    }

    public List<Student> getStudents() {
        if(selectedCourse != null) {
            renderList();
        }
        return students;
    }

    public void renderList() {

        course = Helper.courseTOConverter(services.getCourseService()
                .getCourse(Long.valueOf(selectedCourse), true), true);
        students = course.getStudents();
    }

    public List<Course> getCourseList() {

        courseList = Helper.courseTOListConverter(services.getCourseService()
                .getAll(), false);
        return courseList;
    }

    //ignore for now
    public void getSelectedItems() {
        // Get selected items.
        renderList();
        selectedStudents = new ArrayList<>();
        System.out.println("Att selectedItems: " + students);
        for(Student s : students) {
            //replace firstname to id/ssn
            System.out.println("selectedItems map: " + selectedSSN.toString());
            if(selectedSSN.get(s.getFirstName())) {
                System.out.println("selectedItems id: " + s.getId());
                System.out.println("selectedItems name: " + s.getFirstName());
                selectedStudents.add(s);
            }
        }
        //do things with selectedStudents??
    }

    public void submit() {

        System.out.println("Submit called()");
//        getSelectedItems();
//        for (Student s : selectedStudents) {
//            System.out.println("selectedStudents: " + s.getFirstName());
//        }
        //do things with selectedStudents???
        System.out.println("selected Student: " + selectedStudents);
        System.out.println("selected Student size: " + selectedStudents.size());
//        System.out.println("selected datatable: " + datatable);

        List<Attendance> attendancelist = new ArrayList<>();

        Date d = new Date();

        for(Student s : students) {

            for(Student selected : selectedStudents) {

                if(selected.equals(s)) {

                    Attendance attendance = new Attendance();
                    attendance.setStudent(selected);
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

        }

        int i = services.getAttendanceService().createAttendance(Helper
                .attendanceListConverter(attendancelist));
        Messages.showMessage(i);

    }

    public List<Student> getSelectedStudents() {
        return selectedStudents;
    }

    public void setSelectedStudents(List<Student> selectedStudents) {
        this.selectedStudents = selectedStudents;
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
