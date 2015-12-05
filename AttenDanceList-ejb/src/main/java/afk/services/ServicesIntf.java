package afk;

import afk.attendance.AttendanceServiceIntf;
import afk.course.CourseServiceIntf;
import afk.student.StudentServiceIntf;
import afk.teacher.TeacherServiceIntf;
import javax.ejb.Local;

/**
 *
 * @author c0detupus
 */
@Local
public interface ServicesIntf
{

    public StudentServiceIntf getStudentService();

    public CourseServiceIntf getCourseService();
    
    public TeacherServiceIntf getTeacherService();
    
    public AttendanceServiceIntf getAttendanceService();
}
