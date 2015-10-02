/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.helper;

import afk.entities.CourseEntity;
import afk.entities.StudentEntity;
import afk.entities.TeacherEntity;
import afk.to.CourseTO;
import afk.to.StudentTO;
import afk.to.TeacherTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author c0detupus
 */
public class Helper {

    public static CourseEntity courseTOConverter(CourseTO cto) {

        CourseEntity ce = new CourseEntity();

        ce.setName(cto.getName());
        ce.setCode(cto.getCode());
        ce.setPoints(cto.getPoints());

        return ce;

    }

    public static StudentEntity studentTOConverter(StudentTO s) {
        StudentEntity se = new StudentEntity();

        se.setId(s.getId());
        se.setAddress(s.getAddress());
        se.setAvgAttendance(s.getAvgAttendance());
        se.setCellPhone(s.getCellPhone());
        se.setCity(s.getCity());
        se.setEmail(s.getEmail());
        se.setFirstName(s.getFirstName());
        se.setLastName(s.getLastName());
        se.setPhoneNumber(s.getPhoneNumber());
        se.setSex(s.getSex());
        se.setSocialSecurityNumber(s.getSocialSecurityNumber());
        se.setZipCode(s.getZipCode());

        return se;
    }

    public static TeacherEntity teacherTOConverter(TeacherTO t) {
        TeacherEntity te = new TeacherEntity();

        te.setId(t.getId());
        te.setAddress(t.getAddress());
        te.setCellPhone(t.getCellPhone());
        te.setCity(t.getCity());
        te.setEmail(t.getEmail());
        te.setFirstName(t.getFirstName());
        te.setLastName(t.getLastName());
        te.setPhoneNumber(t.getPhoneNumber());
        te.setSex(t.getSex());
        te.setSocialSecurityNumber(t.getSocialSecurityNumber());
        te.setZipCode(t.getZipCode());

        return te;
    }

    public static List<CourseTO> courseEntityListConverter(List<CourseEntity> courseEntityList) {

        List<CourseTO> cTOList = new ArrayList<>();
        for (CourseEntity ce : courseEntityList) {

            CourseTO cTO = new CourseTO();

            cTO.setId(ce.getId());
            cTO.setName(ce.getName());
            cTO.setCode(ce.getCode());
            cTO.setPoints(ce.getPoints());

            cTOList.add(cTO);
        }

        return cTOList;
    }

    public static List<StudentTO> studentEntityListConverter(List<StudentEntity> eList) {

        List<StudentTO> toList = new ArrayList<>();

        for (StudentEntity s : eList) {
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

            toList.add(sto);
        }

        return toList;
    }

    public static List<TeacherTO> teacherEntityListConverter(List<TeacherEntity> tList) {

        List<TeacherTO> toList = new ArrayList<>();

        for (TeacherEntity t : tList) {
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
            
            toList.add(tto);
        }
        return toList;
    }
}
