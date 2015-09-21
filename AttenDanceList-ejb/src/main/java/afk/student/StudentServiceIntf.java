/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.student;

import java.util.List;
<<<<<<< HEAD:AttenDanceList-ejb/src/main/java/afk/student/StudentServiceIntf.java
import to.StudentTo;
=======
import javax.ejb.Local;
import to.StudentTO;
>>>>>>> bb67a972db162ce84e132ed8537447733019c595:AttenDanceList-ejb/src/main/java/afk/domain/student/StudentServiceIntf.java

/**
 *
 * @author c0detupus
 */
public interface StudentServiceIntf
{

<<<<<<< HEAD:AttenDanceList-ejb/src/main/java/afk/student/StudentServiceIntf.java
    //Create
    public void createStudent(StudentTo studentTo);

    //Read
    public List<StudentTo> getAll();

    public StudentTo getById(long id);

    //Update
    public int updateStudent(long id);
=======
    public List<StudentTO> getAll();

    public void createStudent(StudentTO studentTo);

    public StudentTO findStudent(int id);
>>>>>>> bb67a972db162ce84e132ed8537447733019c595:AttenDanceList-ejb/src/main/java/afk/domain/student/StudentServiceIntf.java

    //Delete
    public int deleteStudent(long id);

}
