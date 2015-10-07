/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.attendance;

import afk.to.AttendanceTO;
import afk.to.CourseTO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author c0detupus
 */
public interface AttendanceServiceIntf
{

    //CREATE
    public int createAttendance(AttendanceTO attendanceTO);

    //READ
    public AttendanceTO getAttendance(long id);

    public List<AttendanceTO> getAll();
    
    public List<AttendanceTO> getAttendanceByDayAndCourse(Date date, CourseTO courseTO);

    //UPDATE
    public int updateAttendance(AttendanceTO attendanceTO);

    //DELETE
    public int deleteAttendance(long id);

}
