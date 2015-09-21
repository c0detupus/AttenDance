package afk;

import afk.domain.student.StudentServiceIntf;
<<<<<<< HEAD
import javax.ejb.EJB;
=======
import java.util.List;
import to.StudentTO;
>>>>>>> bb67a972db162ce84e132ed8537447733019c595

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
