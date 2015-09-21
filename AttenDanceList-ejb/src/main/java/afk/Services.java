package afk;

import afk.student.StudentServiceSLSB;
import javax.ejb.EJB;

/**
 *
 * @author c0detupus
 */
public class Services implements ServicesIntf
{

    @EJB
    private StudentServiceSLSB studentService;

    @Override
    public StudentServiceSLSB getStudentService() {
        return studentService;
    }
    
}
