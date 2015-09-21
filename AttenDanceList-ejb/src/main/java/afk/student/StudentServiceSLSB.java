/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.student;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import afk.to.StudentTO;

/**
 *
 * @author c0detupus
 */
@Stateless
public class StudentServiceSLSB implements StudentServiceIntf
{
    List<StudentTO> studentList;
    
    @Override
    public void createStudent(StudentTO studentTo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<StudentTO> getAll() {
        studentList = new ArrayList<>();
        studentList.add(new StudentTO("Kajri", "Qu","076527771", "23"));
        studentList.add(new StudentTO("Melisa", "Avdavic","07652121", "110"));
        studentList.add(new StudentTO("Urban", "Lundberg", "076527111", "100"));
        return studentList;
    }

    @Override
    public StudentTO getById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateStudent(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StudentTO findStudent(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteStudent(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
