package afk;

import afk.course.CourseServiceSLSB;
import afk.student.StudentServiceIntf;
import afk.student.StudentServiceSLSB;
import javax.ejb.Local;

/**
 *
 * @author c0detupus
 */
@Local
public interface ServicesIntf
{

    public StudentServiceIntf getStudentService();

    public StudentServiceIntf getCourseService();

}
