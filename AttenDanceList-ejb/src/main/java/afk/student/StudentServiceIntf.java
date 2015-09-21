/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.student;

import java.util.List;
import to.StudentTo;

/**
 *
 * @author c0detupus
 */
public interface StudentServiceIntf
{

    //Create
    public void createStudent(StudentTo studentTo);

    //Read
    public List<StudentTo> getAll();

    public StudentTo getById(long id);

    //Update
    public int updateStudent(long id);

    //Delete
    public int deleteStudent(long id);

}
