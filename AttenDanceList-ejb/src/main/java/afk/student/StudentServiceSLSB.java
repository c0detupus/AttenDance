/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.student;

import afk.entities.StudentEntity;
import afk.helper.EJBHelper;
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

    @Override
    public int createStudent(StudentTO studentTo) {
        try {
            em.persist(EJBHelper.studentTOConverter(studentTo));

        } catch (Exception ex) {

            return 0;

        }

        return 1;

    }

    @Override
    public List<StudentTO> getAll() {

        List<StudentEntity> studentList = em
                .createQuery("SELECT s FROM StudentEntity AS s").getResultList();

        return EJBHelper.studentEntityListConverter(studentList);
    }

    @Override
    public StudentTO getStudent(long id) {
        StudentTO sTO = EJBHelper.studentEntityConverter((StudentEntity) em
                .createQuery("SELECT s FROM StudentEntity AS s WHERE s.id = "
                        + id).getSingleResult());

        return sTO;
    }

    @Override
    public int updateStudent(StudentTO studentTO) {
        try {

            em.merge(EJBHelper.studentTOConverter(studentTO));

        } catch (Exception e) {

            return 0;

        }

        return 1;
    }

    @Override
    public int deleteStudent(long id) {
        try {
            em.remove(id);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

}
