/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.domain.student;

import java.util.List;
import javax.ejb.Local;
import to.StudentTO;

/**
 *
 * @author c0detupus
 */
@Local
public interface StudentServiceIntf
{

    public List<StudentTO> getAll();

    public void createStudent(StudentTO studentTo);

    public StudentTO findStudent(int id);

    public int updateStudent(int id);

    public int deleteStudent(int id);
}
