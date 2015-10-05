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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author valance
 */
@Stateless
public class TeacherServiceSLSB implements TeacherServiceIntf {
    
    @PersistenceContext(unitName = "PU")
    private EntityManager em;
    
    @Override
    public void createTeacher(TeacherTO teacherTo) {
        em.persist(EJBHelper.teacherTOConverter(teacherTo));
    }

    @Override
    public List<TeacherTO> getAll() {
        
        List<TeacherEntity> teacherList = em
                .createQuery("SELECT t FROM TeacherEntity AS t").getResultList();
        
        return EJBHelper.teacherEntityListConverter(teacherList);
    }

    @Override
    public TeacherTO getById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateTeacher(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TeacherTO findTeacher(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteTeacher(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
