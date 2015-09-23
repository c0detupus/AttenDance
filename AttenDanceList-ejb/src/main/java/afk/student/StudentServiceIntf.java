/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.student;

import java.util.List;

import afk.to.StudentTO;
import javax.ejb.Local;

/**
 *
 * @author c0detupus
 */
@Local
public interface StudentServiceIntf
{

    //Create
    public void createStudent(StudentTO studentTo);

    //Read
    public List<StudentTO> getAll();

    public StudentTO getById(long id);

    //Update
    public int updateStudent(long id);

    public StudentTO findStudent(int id);

    //Delete
    public int deleteStudent(long id);

}
