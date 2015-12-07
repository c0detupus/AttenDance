package afk.services;

import afk.attendance.AttendanceServiceIntf;
import afk.course.CourseServiceIntf;
import afk.student.StudentServiceIntf;
import afk.teacher.TeacherServiceIntf;
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
    @EJB CourseServiceIntf courseService;
    @EJB TeacherServiceIntf teacherService;
    @EJB AttendanceServiceIntf attendanceService;
    
    @Override
    public StudentServiceIntf getStudentService() {
        return studentService;
    }

    @Override
    public CourseServiceIntf getCourseService() {
        return courseService;
    }

    @Override
    public TeacherServiceIntf getTeacherService() {
        return teacherService;
    }

    @Override
    public AttendanceServiceIntf getAttendanceService() {
        return attendanceService;
    }

    
   
}
