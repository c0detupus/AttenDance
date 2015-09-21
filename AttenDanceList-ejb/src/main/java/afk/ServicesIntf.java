/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk;

import afk.course.CourseServiceSLSB;
import afk.student.StudentServiceSLSB;

/**
 *
 * @author c0detupus
 */
public interface ServicesIntf
{

    public StudentServiceSLSB getStudentService();

    public CourseServiceSLSB getCourseService();

}
