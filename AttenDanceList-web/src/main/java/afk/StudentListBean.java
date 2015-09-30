/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk;

import afk.to.StudentTO;
import helper.Populator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import model.Student;

/**
 *
 * @author c0detupus
 */
@ManagedBean(name = "studentListBean")
public class StudentListBean implements Serializable
{

    @EJB
    private ServicesIntf services;

    private List<StudentTO> students;
    private int studentAmount;

    private Populator populator;

    public List<StudentTO> getStudents() {
//populator.studentTOconverter(
//         students = populator.studentTOconverter(services.getStudentService()
//                .getAll());
        students = new ArrayList<>();
        students = services.getStudentService()
                .getAll();

        return students;
    }

    public int getStudentAmount() {

        studentAmount = students.size();

        return studentAmount;
    }

}
