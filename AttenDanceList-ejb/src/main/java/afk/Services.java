package afk;

import afk.course.CourseServiceSLSB;
import afk.student.StudentServiceSLSB;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @author c0detupus
 */
@Stateless
@Local
public class Services implements ServicesIntf
{

    @Override
    public StudentServiceSLSB getStudentService() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CourseServiceSLSB getCourseService() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
