/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.course;

import afk.to.CourseTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author c0detupus
 */
@Stateless
public class CourseServiceSLSB implements CourseServiceIntf
{

    @Override
    public int createCourse(CourseTO courseTO) {
        return 0;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CourseTO getCourse(long id) {
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CourseTO> getAll() {
        List<CourseTO> courses = new ArrayList<>();

        courses.add(new CourseTO("Java EE", "JEE", "100"));
        courses.add(new CourseTO("Java SE", "JSE", "100"));
        courses.add(new CourseTO("CSS", "CSS", "50"));
        courses.add(new CourseTO("JavaScript", "JS", "50"));

        return courses;

    }

    @Override
    public int updateCourse(long id) {
        return 0;
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteCourse(long id) {
        return 0;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
