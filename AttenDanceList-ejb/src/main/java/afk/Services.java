package afk;

import afk.course.CourseServiceSLSB;
import afk.student.StudentServiceIntf;
import afk.student.StudentServiceSLSB;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @author c0detupus
 */
@Stateless
@Local
public class Services implements ServicesIntf,Serializable
{

    @EJB StudentServiceIntf studentService;
    @EJB StudentServiceIntf courseService;
    
    @Override
    public StudentServiceIntf getStudentService() {
        return studentService;
    }

    @Override
    public StudentServiceIntf getCourseService() {
        return courseService;
    }

}
