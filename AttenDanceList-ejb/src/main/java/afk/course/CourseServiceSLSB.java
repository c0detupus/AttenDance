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

        em.persist(Helper.courseTOConverter(courseTO));
        return 0;
    }

    @Override
    public CourseTO getCourse(long id) {

        CourseTO courseTO = (CourseTO) em
                .createQuery("SELECT c FROM CourseEntity AS c WHERE c.id = "
                        + id).getSingleResult();

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

            successChecker = 0;

        }

        return successChecker;
    }

    @Override
    public int deleteCourse(long id) {

        int removeCheck;
        try {
            em.remove(id);
            removeCheck = 0;
        } catch(Exception e) {
            removeCheck = 1;
        }
        return removeCheck;
    }

}
