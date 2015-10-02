package afk;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import model.Student;

/**
 *
 * @author valance
 */
@ManagedBean(name = "attendanceListBean")
public class AttendanceListBean implements Serializable
{

    private List<Student> student;
    private List<Student> selectedStudent;

    //String in Map is used to check First name, should be replaced to Long/Integer to check id/ssn
    private final Map<String, Boolean> selectedSSN = new HashMap<>();

    //hardcoded, replace with db queries or helper class
    public List<Student> getStudent() {
        student = new ArrayList<>();
//        student.add(new Student("Alexander", "Mehtälä", "076527771", "23"));
//        student.add(new Student("Felicia", "Zhu", "076527771", "23"));
//        student.add(new Student("Kajri", "Qu", "076527771", "23"));

        return student;
    }

    public void getSelectedItems() {
        // Get selected items.
        selectedStudent = new ArrayList<>();
        for(Student s : student) {
            //replace firstname to id/ssn
            if(selectedSSN.get(s.getFirstName())) {
                selectedStudent.add(s);
            }
        }
        //do things with selectedStudent??
    }

    public void submit() {
        getSelectedItems();
        for(Student s : selectedStudent) {
            System.out.println("selectedStudent: " + s.getFirstName());
        }
        //do things with selectedStudent???
    }

    public Map<String, Boolean> getSelectedSSN() {
        return selectedSSN;
    }
}
