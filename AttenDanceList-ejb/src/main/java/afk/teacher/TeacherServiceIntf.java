/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.teacher;

import afk.to.TeacherTO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author valance
 */
@Local
public interface TeacherServiceIntf {

    //Create
    public void createTeacher(TeacherTO teacherTo);

    //Read
    public List<TeacherTO> getAll();

    public TeacherTO getById(long id);

    //Update
    public int updateTeacher(long id);

    public TeacherTO findTeacher(int id);

    //Delete
    public int deleteTeacher(long id);
}
