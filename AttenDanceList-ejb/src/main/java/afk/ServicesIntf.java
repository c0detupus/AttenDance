package afk;

import afk.course.CourseServiceSLSB;
import afk.student.StudentServiceSLSB;

/**
 *
 * @author c0detupus
 */
public interface ServicesIntf
{

    public StudentServiceSLSB getStudentService();

    public CourseServiceSLSB getCourseService();

}
