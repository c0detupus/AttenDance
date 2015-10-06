/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import afk.to.CourseTO;
import afk.to.StudentTO;
import afk.to.TeacherTO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import model.Course;
import model.Student;
import model.Teacher;

/**
 *
 * @author valance
 */
public class Helper
{

    private Map<String, Integer> yearMap;
    private Map<String, Integer> monthMap;

    private Map<String, String> dayMap;

    public Map populateYearMap() {
        yearMap = new LinkedHashMap<>();
        yearMap.put("2014", 2014);
        yearMap.put("2015", 2015);
        yearMap.put("2016", 2016);
        return yearMap;
    }

    public Map populateMonthMap() {
        monthMap = new LinkedHashMap<>();
        monthMap.put("January", 0);
        monthMap.put("February", 1);
        monthMap.put("Mars", 2);
        monthMap.put("April", 3);
        monthMap.put("May", 4);
        monthMap.put("June", 5);
        monthMap.put("July", 6);
        monthMap.put("August", 7);
        monthMap.put("September", 8);
        monthMap.put("October", 9);
        monthMap.put("November", 10);
        monthMap.put("December", 11);
        return monthMap;
    }

    //will populate amount of days depending on month and year(leap year)
    public Map populateDayMap(int month, int year) {
        int iDay = 1;

        Calendar cal = new GregorianCalendar(year, month, iDay);
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        dayMap = new LinkedHashMap<>();

        for(int i = 1; i <= daysInMonth; i++) {
            String day = Integer.toString(i);
            dayMap.put(day, day);
        }
        return dayMap;
    }

    public static Map populateCoursePointsMap() {
        Map<Integer, Integer> coursePointsMap = new LinkedHashMap<>();
        coursePointsMap.put(50, 50);
        coursePointsMap.put(100, 100);
        return coursePointsMap;
    }

    public static List<Student> studentTOListConverter(List<StudentTO> studentTOList) {

        List<Student> studentList = new ArrayList<>();

        for(StudentTO sto : studentTOList) {

            studentList.add(studentTOConverter(sto));
        }

        return studentList;

    }

    public static List<StudentTO> studentListConverter(List<Student> students) {

        List<StudentTO> studentTOs = new ArrayList<>();

        for(Student s : students) {

            studentTOs.add(studentConverter(s));
        }

        return studentTOs;

    }

    public static List<Course> courseTOListConverter(List<CourseTO> courseTOList) {

        List<Course> courseList = new ArrayList<>();

        for(CourseTO cto : courseTOList) {

            courseList.add(courseTOConverter(cto));
        }
        return courseList;
    }

    public static List<CourseTO> courseListConverter(List<Course> courses) {

        List<CourseTO> courseTOs = new ArrayList<>();

        for(Course c : courses) {

            courseTOs.add(courseConverter(c));
        }
        return courseTOs;
    }

    public static List<Teacher> teacherTOListConverter(List<TeacherTO> teacherTOList) {

        List<Teacher> teacherList = new ArrayList<>();

        for(TeacherTO tto : teacherTOList) {
            teacherList.add(teacherTOConverter(tto));
        }
        return teacherList;
    }

    public static CourseTO courseConverter(Course c) {
        CourseTO cto = new CourseTO();

        cto.setTeacher(teacherConverter(c.getTeacher()));
        cto.setId(c.getId());
        cto.setName(c.getName());
        cto.setCode(c.getCode());
        cto.setPoints(c.getPoints());

        return cto;
    }

    public static Course courseTOConverter(CourseTO cto) {
        Course c = new Course();

        c.setTeacher(teacherTOConverter(cto.getTeacher()));
        c.setId(cto.getId());
        c.setName(cto.getName());
        c.setCode(cto.getCode());
        c.setPoints(cto.getPoints());

        return c;
    }

    public static Student studentTOConverter(StudentTO sto) {
        Student s = new Student();

        s.setId(sto.getId());
        s.setAddress(sto.getAddress());
        s.setAvgAttendance(sto.getAvgAttendance());
        s.setCellPhone(sto.getCellPhone());
        s.setCity(sto.getCity());
        s.setEmail(sto.getEmail());
        s.setFirstName(sto.getFirstName());
        s.setLastName(sto.getLastName());
        s.setPhoneNumber(sto.getPhoneNumber());
        s.setSex(sto.getSex());
        s.setSocialSecurityNumber(sto.getSocialSecurityNumber());
        s.setZipCode(sto.getZipCode());
        s.setCourses(courseTOListConverter(sto.getCourses()));

        return s;
    }

    public static StudentTO studentConverter(Student s) {
        StudentTO sto = new StudentTO();

        sto.setId(s.getId());
        sto.setAddress(s.getAddress());
        sto.setAvgAttendance(s.getAvgAttendance());
        sto.setCellPhone(s.getCellPhone());
        sto.setCity(s.getCity());
        sto.setEmail(s.getEmail());
        sto.setFirstName(s.getFirstName());
        sto.setLastName(s.getLastName());
        sto.setPhoneNumber(s.getPhoneNumber());
        sto.setSex(s.getSex());
        sto.setSocialSecurityNumber(s.getSocialSecurityNumber());
        sto.setZipCode(s.getZipCode());
        sto.setCourses(courseListConverter(s.getCourses()));

        return sto;
    }

    public static TeacherTO teacherConverter(Teacher t) {
        TeacherTO tto = new TeacherTO();

        tto.setId(t.getId());
        tto.setAddress(t.getAddress());
        tto.setCellPhone(t.getCellPhone());
        tto.setCity(t.getCity());
        tto.setEmail(t.getEmail());
        tto.setFirstName(t.getFirstName());
        tto.setLastName(t.getLastName());
        tto.setPhoneNumber(t.getPhoneNumber());
        tto.setSex(t.getSex());
        tto.setSocialSecurityNumber(t.getSocialSecurityNumber());
        tto.setZipCode(t.getZipCode());

        return tto;
    }

    public static Teacher teacherTOConverter(TeacherTO tto) {
        Teacher t = new Teacher();

        t.setId(tto.getId());
        t.setAddress(tto.getAddress());
        t.setCellPhone(tto.getCellPhone());
        t.setCity(tto.getCity());
        t.setEmail(tto.getEmail());
        t.setFirstName(tto.getFirstName());
        t.setLastName(tto.getLastName());
        t.setPhoneNumber(tto.getPhoneNumber());
        t.setSex(tto.getSex());
        t.setSocialSecurityNumber(tto.getSocialSecurityNumber());
        t.setZipCode(tto.getZipCode());

        return t;
    }
}
