/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.course;

import afk.entities.CourseEntity;
import afk.helper.EJBHelper;
import afk.to.CourseTO;
import afk.to.StudentTO;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author c0detupus
 */
@DeclareRoles({"headmaster", "teacher"})
@Stateless
public class CourseServiceSLSB implements CourseServiceIntf
{

    @PersistenceContext(unitName = "PU")
    EntityManager em;

    @PermitAll
    @Override
    public int createCourse(CourseTO courseTO) {

        try {
            em.persist(EJBHelper.courseTOConverter(courseTO, false));

        } catch(Exception ex) {

            return 0;

        }

        return 1;
    }

    @PermitAll
    @Override
    public CourseTO getCourse(long id, boolean getStudents) {

        CourseTO courseTO = EJBHelper.courseEntityConverter((CourseEntity) em
                .find(CourseEntity.class, id), getStudents);

        return courseTO;

    }

    @PermitAll
    @Override
    public List<CourseTO> getAll() {

        List<CourseEntity> courseEntites = em
                .createQuery("SELECT c FROM CourseEntity AS c").getResultList();

        return EJBHelper.courseEntityListConverter(courseEntites, true);

    }

    @PermitAll
    @Override
    public int updateCourse(CourseTO courseTO) {

        try {

            em.merge(EJBHelper.courseTOConverter(courseTO, false));

        } catch(Exception e) {

            return 0;

        }

        return 1;
    }

    @PermitAll
    @Override
    public int deleteCourse(long courseId) {

        try {

            Query q = em
                    .createQuery("DELETE FROM CourseEntity c WHERE c.id = "
                            + courseId);

            q.executeUpdate();

        } catch(Exception e) {

            return 0;
        }
        return 1;
    }

    @PermitAll
    @Override
    public List<StudentTO> getAllStudentsInCourse(long id) {

        CourseEntity c = (CourseEntity) em
                .createQuery("SELECT c FROM CourseEntity AS c WHERE c.id = :idParam")
                .setParameter("idParam", id).getSingleResult();

        em.refresh(c);
        return EJBHelper.studentEntityListConverter(c.getStudents(), false);

    }

}
