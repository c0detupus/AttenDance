/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.listbeans;

import afk.services.ServicesIntf;
import afk.helper.Helper;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import afk.model.Student;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author c0detupus
 */
@ManagedBean(name = "studentListBean")
public class StudentListBean implements Serializable {

    @EJB
    private ServicesIntf services;

    private List<Student> students;
    private int studentAmount;
    
    private Student student;
    
    public List<Student> getStudents() {

        students = Helper.studentTOListConverter(services.getStudentService().getAll(), false);

        return students;
    }

    public void onRowSelect(SelectEvent event) throws IOException {
        student = (Student) event.getObject();

        FacesContext.getCurrentInstance().getExternalContext().redirect("studentView.xhtml?id=" + student.getId());
    }

    public int getStudentAmount() {

        studentAmount = students.size();

        return studentAmount;
    }

}
