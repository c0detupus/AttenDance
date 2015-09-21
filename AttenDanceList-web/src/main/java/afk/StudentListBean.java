/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk;

import helper.Populator;
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

    @EJB
    private Services services;

    private List<Student> students;
    private int studentAmount;

    private Populator populator;

    public List<Student> getStudents() {

        students = populator.studentTOconverter(services.getStudentService()
                .getAll());

        return students;
    }

    public int getStudentAmount() {

        studentAmount = students.size();

        return studentAmount;
    }

}
