/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Student;

/**
 *
 * @author c0detupus
 */
@ManagedBean(name = "studentListBean")
@SessionScoped
public class StudentListBean
{
//    @EJB Services services;

    
    private String firstName;
    private List<Student> students;
    private int studentAmount;

    public List<Student> getStudents() {
        List<Student> result; 
        students = new ArrayList<>();
        students.add(new Student("Kajri", "Qu","076527771", "23"));
        students.add(new Student("Melisa", "Avdavic","07652121", "110"));
        students.add(new Student("Urban", "Lundberg", "076527111", "100"));
//        List<StudentTo>  = services.getStudentService().getAll();
        // TeacherTo tto= services.getTeacherService().findTeacherA(19);
//        this.setFirstName(tto.getFirstName());
//        this.setFirstName(tto.getFirstName());
//        this.setFirstName(tto.getFirstName());
        
        return students;
    }

    public int getStudentAmount() {

        studentAmount = students.size();

        return studentAmount;
    }

}
