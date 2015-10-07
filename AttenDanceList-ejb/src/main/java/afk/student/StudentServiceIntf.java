package afk.student;

import java.util.List;

import afk.to.StudentTO;
import javax.ejb.Local;

/**
 *
 * @author c0detupus
 */
@Local
public interface StudentServiceIntf {

    //Create
    public int createStudent(StudentTO studentTo);

    //Read
    public List<StudentTO> getAll();

    public StudentTO getStudent(long id, boolean getCourse);

    //Update
    public int updateStudent(StudentTO studentTO);

    //Delete
    public int deleteStudent(long id);

}
