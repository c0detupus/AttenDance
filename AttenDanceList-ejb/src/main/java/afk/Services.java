/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk;

import afk.domain.student.StudentServiceIntf;
import java.util.List;
import to.StudentTO;

/**
 *
 * @author c0detupus
 */
public class Services implements ServicesIntf
{

    
    @EJB StudentServiceIntf studentServiceIntf;
    @EJB TeacherServiceIntf steacherServiceIntf;
    
    
    
    @Override
    public StudentServiceIntf getStudentService() {
        return getStudentServiceIntf();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public StudentServiceIntf getStudentServiceIntf() {
        return studentServiceIntf;
    }

    public void setStudentServiceIntf(StudentServiceIntf studentServiceIntf) {
        this.studentServiceIntf = studentServiceIntf;
    }

   
    
}
