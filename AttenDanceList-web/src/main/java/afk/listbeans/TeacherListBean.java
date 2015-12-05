/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk;

import helper.Helper;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import model.Teacher;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author valance
 */
@ManagedBean(name = "teacherListBean")
public class TeacherListBean implements Serializable {

    @EJB
    private ServicesIntf services;

    private List<Teacher> teachers;
    private int teacherAmount;

    private Teacher teacher;

    public List<Teacher> getTeachers() {

        teachers = Helper.teacherTOListConverter(services.getTeacherService().getAll());

        return teachers;
    }

    public void onRowSelect(SelectEvent event) throws IOException {
        teacher = (Teacher) event.getObject();

        FacesContext.getCurrentInstance().getExternalContext().redirect("teacherView.xhtml?id=" + teacher.getId());
    }

    public int getTeacherAmount() {

        teacherAmount = teachers.size();

        return teacherAmount;
    }
}
