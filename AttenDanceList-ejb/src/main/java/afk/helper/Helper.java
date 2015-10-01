/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.helper;

import afk.entities.CourseEntity;
import afk.to.CourseTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author c0detupus
 */
public class Helper
{

    public static CourseEntity convertCourseTO(CourseTO cto) {

        CourseEntity ce = new CourseEntity();

        ce.setName(cto.getName());
        ce.setCode(cto.getCode());
        ce.setPoints(cto.getPoints());

        return ce;

    }

    public static List<CourseTO> courseEntityConverter(List<CourseEntity> courseEntityList) {

        List<CourseTO> cTOList = new ArrayList<>();

        for(CourseEntity ce : courseEntityList) {

            CourseTO cTO = new CourseTO();

            cTO.setId(ce.getId());
            cTO.setName(ce.getName());
            cTO.setCode(ce.getCode());
            cTO.setPoints(ce.getPoints());

            cTOList.add(cTO);

        }

        return cTOList;

    }

}
