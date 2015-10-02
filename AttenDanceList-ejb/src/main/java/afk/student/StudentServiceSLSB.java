/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.student;

import afk.entities.StudentEntity;
import afk.helper.Helper;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import afk.to.StudentTO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author c0detupus
 */
@Stateless
public class StudentServiceSLSB implements StudentServiceIntf {    

    @PersistenceContext(unitName = "PU")
    private EntityManager em;
    
    private int removeCheck;
    
    @Override
    public void createStudent(StudentTO studentTo) {
        //convert to entity
        em.persist(Helper.studentTOConverter(studentTo));
    }
    
    @Override
    public List<StudentTO> getAll() {
        
        List<StudentEntity> studentList = em
                .createQuery("SELECT s FROM StudentEntity AS s").getResultList();

        return Helper.studentEntityListConverter(studentList);
    }
    
    @Override
    public StudentTO getById(long id) {
        return null;
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int updateStudent(long id) {
        return 0;
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public StudentTO findStudent(int id) {
        return null;//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int deleteStudent(long id) {
        try {
            em.remove(id);
            removeCheck = 0;
        } catch (Exception e) {
            removeCheck = 1;
        }
        return removeCheck;
    }
    
}
