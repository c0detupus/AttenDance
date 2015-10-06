/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.to;

import java.util.List;

/**
 *
 * @author kajri.qu
 */
public class CourseTO
{

    private long id;

    private String name,
            code,
            points;

//    private List<StudentTO> students;
//
//    private TeacherTO teacher;

//    public TeacherTO getTeacher() {
//        return teacher;
//    }
//
//    public void setTeacher(TeacherTO teacher) {
//        this.teacher = teacher;
//    }
//
//    public List<StudentTO> getStudents() {
//        return students;
//    }
//
//    public void setStudents(List<StudentTO> students) {
//        this.students = students;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

}
