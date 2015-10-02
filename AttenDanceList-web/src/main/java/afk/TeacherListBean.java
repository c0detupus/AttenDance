/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk;

import helper.Helper;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import model.Teacher;

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

    public List<Teacher> getTeachers() {

        teachers = Helper.teacherTOListConverter(services.getTeacherService().getAll());

        return teachers;
    }

    public int getTeacherAmount() {

        teacherAmount = teachers.size();

        return teacherAmount;
}
}
