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

        em.persist(Helper.convertCourseTO(courseTO));
        return 0;
    }

    @Override
    public CourseTO getCourse(long id) {
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CourseTO> getAll() {

        List<CourseEntity> courseEntites = em
                .createQuery("SELECT c FROM ROOT.COURSE c").getResultList();

        return Helper.courseEntityConverter(courseEntites);

    }

    @Override
    public int updateCourse(long id) {
        return 0;
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteCourse(long id) {
        return 0;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
