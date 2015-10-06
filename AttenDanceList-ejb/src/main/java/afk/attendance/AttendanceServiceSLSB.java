package afk.attendance;

import afk.entities.AttendanceEntity;
import afk.helper.EJBHelper;
import afk.to.AttendanceTO;
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
                        .createQuery("SELECT a FROM AttendanceEntity AS a WHERE a.id = "
                                + id).getSingleResult());

        return attendanceTO;

    }

    @Override
    public List<AttendanceTO> getAll() {

        List<AttendanceEntity> attendanceEntitys = em
                .createQuery("SELECT a FROM AttendanceEntity AS a")
                .getResultList();

        return EJBHelper.attendanceEntityListConverter(attendanceEntitys);

    }

    @Override
    public int updateAttendance(AttendanceTO attendanceTO) {

        try {
            em.refresh(EJBHelper.attendanceTOConverter(attendanceTO));

        } catch(Exception ex) {
            return 0;
        }

        return 1;
    }

    @Override
    public int deleteAttendance(AttendanceTO attendanceTO) {

        try {
            em.remove(EJBHelper.attendanceTOConverter(attendanceTO));
        } catch(Exception ex) {

            return 0;
        }

        return 1;

    }

}
