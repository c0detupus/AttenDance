/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author valance
 */
public class Populator {

    private Map<String, String> courseMap;
    private Map<String, String> studentMap;
    private Map<String, Integer> yearMap;
    private Map<String, Integer> monthMap;

    private Map<String, String> dayMap;
    
    private Map<Integer, Integer> coursePointsMap;

    //will populate the map depending on database
    //hardcoded for now
    public Map populateCoursesMap() {
        courseMap = new LinkedHashMap<>();
        courseMap.put("Java EE", "Java EE"); //label, value
        courseMap.put("JavaScript", "JavaScript");
        courseMap.put("CSS", "CSS");
        return courseMap;
    }

    public Map populateStudentMap() {
        studentMap = new LinkedHashMap<>();
        studentMap.put("AM", "Alexander Mehtälä");
        studentMap.put("FZ", "Felicia Zhu");
        studentMap.put("KQ", "Kajri Qu");
        return studentMap;
    }

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

        for (int i = 1; i <= daysInMonth; i++) {
            String day = Integer.toString(i);
            dayMap.put(day, day);
        }
        return dayMap;
    }
    
    public Map populateCoursePointsMap(){
        coursePointsMap = new LinkedHashMap<>();
        coursePointsMap.put(50, 50);
        coursePointsMap.put(100, 100);
        return coursePointsMap;
    }
}
