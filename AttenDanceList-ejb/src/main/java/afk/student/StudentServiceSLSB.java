package afk.student;

import afk.entities.StudentEntity;
import afk.helper.EJBHelper;
import java.util.List;
import javax.ejb.Stateless;
import afk.to.StudentTO;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author c0detupus
 */
@DeclareRoles({"headmaster", "teacher"})
@Stateless
public class StudentServiceSLSB implements StudentServiceIntf
{

    @PersistenceContext(unitName = "PU")
    private EntityManager em;

    @PermitAll
    @Override
    public int createStudent(StudentTO studentTo) {
        try {
            em.persist(EJBHelper.studentTOConverter(studentTo, true));

        } catch(Exception ex) {

            return 0;

        }

        return 1;

    }

    @PermitAll
    @Override
    public List<StudentTO> getAll() {

        List<StudentEntity> studentList = em
                .createQuery("SELECT s FROM StudentEntity AS s").getResultList();

        return EJBHelper.studentEntityListConverter(studentList, true);
    }

    @PermitAll
    @Override
    public StudentTO getStudent(long id, boolean getCourse) {
//        StudentTO sTO = EJBHelper.studentEntityConverter((StudentEntity) em
//                .createQuery("SELECT s FROM StudentEntity AS s WHERE s.id = "
//                        + id).getSingleResult());

        StudentTO sTO = EJBHelper.studentEntityConverter((StudentEntity) em
                .find(StudentEntity.class, id), getCourse);

        return sTO;
    }

    @PermitAll
    @Override
    public int updateStudent(StudentTO studentTO) {
        try {

            em.merge(EJBHelper.studentTOConverter(studentTO, true));

        } catch(Exception e) {

            return 0;

        }

        return 1;
    }

    @PermitAll
    @Override
    public int deleteStudent(long id) {
        try {

            Query q = em
                    .createQuery("DELETE FROM StudentEntity s WHERE s.id = "
                            + id);

            q.executeUpdate();

        } catch(Exception e) {

            System.out.println(e);
            return 0;
        }
        return 1;
    }
}
