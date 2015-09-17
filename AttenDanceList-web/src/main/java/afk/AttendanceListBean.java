/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk;

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
public class AttendanceListBean {

    private List<Student> student;
    private List<Student> selectedStudent;
    
    //String in Map is used to check First name, should be replaced to Long/Integer to check id/ssn
    private final Map<String, Boolean> selectedSSN = new HashMap<>();
    
     //hardcoded, replace with db queries or helper class
    public List<Student> getStudent() {
        student = new ArrayList<>();
        student.add(new Student("Alexander", "Mehtälä"));
        student.add(new Student("Felicia", "Zhu"));
        student.add(new Student("Kajri", "Qu"));

        return student;
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
    
    public void submit(){
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
