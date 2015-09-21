/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.student;

import java.util.List;
import javax.ejb.Stateless;
import to.StudentTO;

/**
 *
 * @author c0detupus
 */
@Stateless
public class StudentServiceSlsb implements StudentServiceIntf
{

    @Override
<<<<<<< HEAD:AttenDanceList-ejb/src/main/java/afk/student/StudentServiceSlsb.java
    public void createStudent(StudentTo studentTo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<StudentTo> getAll() {
=======
    public List<StudentTO> getAll() {
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createStudent(StudentTO studentTo ) {
>>>>>>> bb67a972db162ce84e132ed8537447733019c595:AttenDanceList-ejb/src/main/java/afk/domain/student/StudentServiceSlsb.java
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
<<<<<<< HEAD:AttenDanceList-ejb/src/main/java/afk/student/StudentServiceSlsb.java
    public StudentTo getById(long id) {
=======
    public StudentTO findStudent(int id) {
>>>>>>> bb67a972db162ce84e132ed8537447733019c595:AttenDanceList-ejb/src/main/java/afk/domain/student/StudentServiceSlsb.java
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateStudent(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteStudent(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
