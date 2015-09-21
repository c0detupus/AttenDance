/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.domain.student;

import java.util.List;
import javax.ejb.Local;
import to.StudentTo;

/**
 *
 * @author c0detupus
 */
@Local
public interface StudentServiceIntf
{

    public List<StudentTo> getAll();

    public void createStudent(StudentTo studentTo);

    public StudentTo findStudent(int id);

    public int updateStudent(int id);

    public int deleteStudent(int id);
}
