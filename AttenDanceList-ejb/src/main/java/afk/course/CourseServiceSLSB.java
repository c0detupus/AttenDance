/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.course;

import afk.entities.CourseEntity;
import afk.helper.Helper;
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

        int successChecker;

        try {
            em.persist(Helper.courseTOConverter(courseTO));

        } catch(Exception ex) {

            return 0;

        }

        return 1;
    }

    @Override
    public CourseTO getCourse(long id) {

        CourseTO courseTO = Helper.courseEntityConverter((CourseEntity) em
                .createQuery("SELECT c FROM CourseEntity AS c WHERE c.id = "
                        + id).getSingleResult());

        return courseTO;

    }

    @Override
    public List<CourseTO> getAll() {

        List<CourseEntity> courseEntites = em
                .createQuery("SELECT c FROM CourseEntity AS c").getResultList();

        return Helper.courseEntityListConverter(courseEntites);

    }

    @Override
    public int updateCourse(long id) {

        CourseTO courseTO = getCourse(id);

        int successChecker;

        try {

            em.refresh(courseTO);
            successChecker = 1;

        } catch(Exception e) {

            return 0;

        }

        return 1;
    }

    @Override
    public int deleteCourse(long id) {

        try {
            em.remove(id);

        } catch(Exception e) {

            return 0;
        }
        return 1;
    }

}
