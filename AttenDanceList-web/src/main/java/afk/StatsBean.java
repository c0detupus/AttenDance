/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author c0detupus
 */
@ManagedBean(name = "statsBean")
@RequestScoped
public class StatsBean {

//    private Courses courses;
//    private List<Courses> coursesList;
    private String currentCourse;
    private int currentMonth;
    private String currentDay;
    private int currentYear;

    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    private Map<String, Integer> yearMap;
    private Map<String, String> coursesMap;
    private Map<String, Integer> monthMap;
    private Map<String, String> dayMap;

    public String getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(String currentDay) {
        this.currentDay = currentDay;
    }

    public int getCurrentMonth() {
        return currentMonth;
    }

    public void setCurrentMonth(int currentMonth) {
        this.currentMonth = currentMonth;
    }

    @PostConstruct
    public void init() {
        //will populate the map depending on database
        //hardcoded for now

        coursesMap = new LinkedHashMap<>();
        coursesMap.put("Java EE", "Java EE"); //label, value
        coursesMap.put("JavaScript", "JavaScript");
        coursesMap.put("CSS", "CSS");

        monthMap = new LinkedHashMap<>();
        monthMap.put("January", 0);
        monthMap.put("February", 1);
        monthMap.put("Mars", 2);

        yearMap = new LinkedHashMap<>();
        yearMap.put("2014", 2014);
        yearMap.put("2015", 2015);
        yearMap.put("2016", 2016);
        populateDayMap();
//        coursesList = new ArrayList<>();
//        this.coursesList.add(new Courses("Java EE", 100));
//        this.coursesList.add(new Courses("JavaScript", 50));
//        this.coursesList.add(new Courses("CSS", 50));
    }

    public void submit() {
        populateDayMap();
    }

    public void onMonthSelect(ValueChangeEvent e) {
//        String temp = e.getNewValue().toString();
//        currentMonth = Integer.parseInt(temp);
        populateDayMap();
    }

    //will populate dayMap depending on which month is selected.
    //
    private void populateDayMap() {
        int iDay = 1;

        Calendar cal = new GregorianCalendar(currentYear, currentMonth, iDay);
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        dayMap = new LinkedHashMap<>();
        for (int i = 1; i <= daysInMonth; i++) {
            String temp = Integer.toString(i);
            dayMap.put(temp, temp);
        }
    }

    public Map<String, Integer> getYearMap() {
        return yearMap;
    }

    public Map<String, String> getDayMap() {
        return dayMap;
    }

    public Map<String, Integer> getMonthMap() {
        return monthMap;
    }

    public Map<String, String> getCoursesMap() {
        return coursesMap;
    }

    public String getCurrentCourse() {
        return currentCourse;
    }

    public void setCurrentCourse(String currentCourse) {
        this.currentCourse = currentCourse;
    }
}
