package afk;

import afk.domain.student.StudentServiceIntf;
import javax.ejb.EJB;

/**
 *
 * @author c0detupus
 */
public class Services implements ServicesIntf
{

    
    @EJB StudentServiceIntf studentServiceIntf;

    
    
    
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
