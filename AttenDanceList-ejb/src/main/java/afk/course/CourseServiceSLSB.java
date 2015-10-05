/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.course;

import afk.entities.CourseEntity;
import afk.helper.EJBHelper;
import afk.to.CourseTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author c0detupus
 */
@Stateless
public class CourseServiceSLSB implements CourseServiceIntf
{

    @PersistenceContext(unitName = "PU")
    EntityManager em;

    @Override
    public int createCourse(CourseTO courseTO) {

        try {
            em.persist(EJBHelper.courseTOConverter(courseTO));

        } catch(Exception ex) {

            return 0;

        }

        return 1;
    }

    @Override
    public CourseTO getCourse(long id) {

        CourseTO courseTO = EJBHelper.courseEntityConverter((CourseEntity) em
                .createQuery("SELECT c FROM CourseEntity AS c WHERE c.id = "
                        + id).getSingleResult());

        return courseTO;

    }

    @Override
    public List<CourseTO> getAll() {

        List<CourseEntity> courseEntites = em
                .createQuery("SELECT c FROM CourseEntity AS c").getResultList();

        return EJBHelper.courseEntityListConverter(courseEntites);

    }

    @Override
    public int updateCourse(CourseTO courseTO) {

        try {

            em.merge(EJBHelper.courseTOConverter(courseTO));

        } catch(Exception e) {

            return 0;

        }

        return 1;
    }

    @Override
    public int deleteCourse(long courseId) {

//        CourseEntity ce = new CourseEntity();
//        ce.setId(courseId);
        try {
//            System.out.println("SLSB: " + ce.getId());
//            em.getTransaction().begin();
//            em.remove(ce);
//            em.getTransaction().commit();

            em.getTransaction().begin();
            CourseEntity ce = em.find(CourseEntity.class, courseId);
            em.remove(ce);
            em.getTransaction().commit();

//            em.getTransaction().begin();
//            System.out.println("SLSB: " + courseTO.getId());
//            System.out.println("SLSB: " + courseTO.getName());
//            em.remove(EJBHelper.courseTOConverter(courseTO));
//            em.getTransaction().commit();
        } catch(Exception e) {

            System.out.println(e);
            return 0;
        }
        return 1;
    }

}
