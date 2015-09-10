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
import javax.faces.event.AjaxBehaviorEvent;

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

    private int currentYear;
    private int currentMonth;
    private String currentDay;

    private boolean currentOneRadioValue;

    private int toYear;
    private int toMonth;
    private String toDay;

    private Map<String, String> coursesMap;
    private Map<String, Integer> yearMap;
    private Map<String, Integer> monthMap;
    private Map<String, Integer> toYearMap;
    private Map<String, Integer> toMonthMap;

    private Map<String, String> dayMap;
    private Map<String, String> toDayMap;

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

        currentOneRadioValue = false;

        populateDayMap();

//        coursesList = new ArrayList<>();
//        this.coursesList.add(new Courses("Java EE", 100));
//        this.coursesList.add(new Courses("JavaScript", 50));
//        this.coursesList.add(new Courses("CSS", 50));
    }

    public void onMonthSelect(AjaxBehaviorEvent e) {
        System.out.println("Called: onMonthSelect");
        populateDayMap();
        if (currentOneRadioValue == true) {
            toMonthMap = monthMap;
            toYearMap = yearMap;
            populateDayMap2();
        }
    }

    public void onRadioToggle(AjaxBehaviorEvent e) {
        currentOneRadioValue = !currentOneRadioValue != true;
        populateDayMap2();
    }

    //will populate dayMap depending on which month is selected.
    //
    private void populateDayMap() {
        int iDay = 1;

        Calendar cal = new GregorianCalendar(currentYear, currentMonth, iDay);
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        dayMap = new LinkedHashMap<>();

        for (int i = 1; i <= daysInMonth; i++) {
            String day = Integer.toString(i);
            dayMap.put(day, day);
        }
    }

    private void populateDayMap2() {
        System.out.println("Called: populateDayMap2 ");
        int iDay = 1;

        Calendar cal = new GregorianCalendar(toYear, toMonth, iDay);
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        toDayMap = new LinkedHashMap<>();

        for (int i = 1; i <= daysInMonth; i++) {
            String day = Integer.toString(i);
            toDayMap.put(day, day);
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

    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public boolean getCurrentOneRadioValue() {
        return currentOneRadioValue;
    }

    public void setCurrentOneRadioValue(boolean currentOneRadioValue) {
        this.currentOneRadioValue = currentOneRadioValue;
    }

    public int getToMonth() {
        return toMonth;
    }

    public void setToMonth(int toMonth) {
        this.toMonth = toMonth;
    }

    public String getToDay() {
        return toDay;
    }

    public void setToDay(String toDay) {
        this.toDay = toDay;
    }

    public int getToYear() {
        return toYear;
    }

    public void setToYear(int toYear) {
        this.toYear = toYear;
    }

    public Map<String, String> getToDayMap() {
        return toDayMap;
    }

    public Map<String, Integer> getToYearMap() {
        return toYearMap;
    }

    public Map<String, Integer> getToMonthMap() {
        return toMonthMap;
    }
}
