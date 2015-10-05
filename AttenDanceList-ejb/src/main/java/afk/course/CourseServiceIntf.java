/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.course;

import afk.to.CourseTO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author c0detupus
 */
@Local
public interface CourseServiceIntf
{

    //Create
    public int createCourse(CourseTO courseTO);

    //Read
    public CourseTO getCourse(long id);

    public List<CourseTO> getAll();

    //Update
    public int updateCourse(CourseTO courseTO);

    //Delete
    public int deleteCourse(long id);

}
