package afk.attendance;

import afk.entities.AttendanceEntity;
import afk.entities.CourseEntity;
import afk.helper.EJBHelper;
import afk.to.AttendanceTO;
import afk.to.CourseTO;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

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
    public int deleteAttendance(long id) {

        try {

            Query q = em
                    .createQuery("DELETE FROM AttendanceEntity a WHERE a.id = "
                            + id);

            q.executeUpdate();

        } catch(Exception e) {

            System.out.println(e);
            return 0;
        }
        return 1;
    }

    @Override
    public List<AttendanceTO> getAttendanceByDayAndCourse(Date date, CourseTO courseTO) {

        CourseEntity courseEntity = EJBHelper.courseTOConverter(courseTO);

        List<AttendanceEntity> attendanceEntitys = em
                .createQuery("SELECT a FROM AttendanceEntity AS a WHERE a.dateField = :selectedDate AND a.courses = :selectedCourse")
                .setParameter("selectedDate", date, TemporalType.DATE)
                .setParameter("selectedCourse", courseEntity).getResultList();

        return EJBHelper.attendanceEntityListConverter(attendanceEntitys);

    }

}
