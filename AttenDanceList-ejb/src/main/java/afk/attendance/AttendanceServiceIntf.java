/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.attendance;

import afk.entities.AttendanceEntity;
import afk.to.AttendanceTO;
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
    public AttendanceEntity getAttendance(long id);

    public List<AttendanceEntity> getAll();

    //UPDATE
    public int updateAttendance(long id);

    //DELETE
    public int deleteAttendance(long id);

}
