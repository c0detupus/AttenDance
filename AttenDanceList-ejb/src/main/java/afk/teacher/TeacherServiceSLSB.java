/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.teacher;

import afk.entities.TeacherEntity;
import afk.helper.EJBHelper;
import afk.to.TeacherTO;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author valance
 */
@DeclareRoles({"headmaster", "teacher"})
@Stateless
public class TeacherServiceSLSB implements TeacherServiceIntf {

    @PersistenceContext(unitName = "PU")
    private EntityManager em;
    
    @RolesAllowed("headmaster")
    @Override
    public int createTeacher(TeacherTO teacherTo) {
        try {
            em.persist(EJBHelper.teacherTOConverter(teacherTo));

        } catch (Exception ex) {

            return 0;

        }

        return 1;
    }
    
    @RolesAllowed({"headmaster", "teacher"})
    @Override
    public TeacherTO getTeacher(long id) {
        TeacherTO tto = EJBHelper.teacherEntityConverter((TeacherEntity) em
                .createQuery("SELECT t FROM TeacherEntity AS t WHERE t.id = "
                        + id).getSingleResult());

        return tto;
    }
    
    @RolesAllowed({"headmaster", "teacher"})
    @Override
    public List<TeacherTO> getAll() {

        List<TeacherEntity> teacherList = em
                .createQuery("SELECT t FROM TeacherEntity AS t").getResultList();

        return EJBHelper.teacherEntityListConverter(teacherList);
    }
    
    @RolesAllowed("headmaster")
    @Override
    public int updateTeacher(TeacherTO teacherTO) {
        try {

            em.merge(EJBHelper.teacherTOConverter(teacherTO));

        } catch (Exception e) {

            return 0;

        }

        return 1;
    }
    
    @RolesAllowed("headmaster")
    @Override
    public int deleteTeacher(long id) {
        try {

            Query q = em
                    .createQuery("DELETE FROM TeacherEntity t WHERE t.id = "
                            + id);

            q.executeUpdate();

        } catch (Exception e) {

            System.out.println(e);
            return 0;
        }
        return 1;
    }
}
