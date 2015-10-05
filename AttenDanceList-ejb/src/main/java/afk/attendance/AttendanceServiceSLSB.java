package afk.attendance;

import afk.entities.AttendanceEntity;
import afk.helper.EJBHelper;
import afk.to.AttendanceTO;
import afk.to.CourseTO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author c0detupus
 */
public class AttendanceServiceSLSB implements AttendanceServiceIntf
{

    @PersistenceContext(unitName = "PU")
    EntityManager em;

    @Override
    public int createAttendance(AttendanceTO attendanceTO) {

        try {

            em.persist(EJBHelper.attendanceTOConverter(attendanceTO));

        } catch(Exception ex) {

            return 0;
        }

        return 1;

    }

    @Override
    public AttendanceTO getAttendance(long id) {

        AttendanceTO attendanceTO = EJBHelper
                .attendanceEntityConverter((AttendanceEntity) em
                        .createQuery("SELECT c FROM CourseEntity AS c WHERE c.id = "
                                + id).getSingleResult());

        return attendanceTO;

    }

    @Override
    public List<AttendanceEntity> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateAttendance(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteAttendance(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
