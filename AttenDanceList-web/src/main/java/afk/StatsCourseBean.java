package afk;

import helper.Helper;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author c0detupus
 */
@ManagedBean(name = "statsCourseBean")
@SessionScoped
public class StatsCourseBean implements Serializable {

    private String currentCourse;

    private int currentYear;
    private int currentMonth;
    private String currentDay;

    private boolean currentOneRadioValue;

    private int toYear;
    private int toMonth;
    private String toDay;

    private Map<String, String> courseMap;
    private Map<String, Integer> yearMap;
    private Map<String, Integer> monthMap;
    private Map<String, String> dayMap;
    private Map<String, String> toDayMap;

    private Helper pop;

    @PostConstruct
    public void init() {
        //will populate the map depending on database
        //hardcoded for now
        pop = new Helper();

        yearMap = pop.populateYearMap();
        monthMap = pop.populateMonthMap();
        dayMap = pop.populateDayMap(currentMonth, currentYear);

        currentOneRadioValue = false;
    }

    public void onMonthOrYearSelect(AjaxBehaviorEvent e) {
        dayMap = pop.populateDayMap(currentMonth, currentYear);
        if (currentOneRadioValue == true) {

            toDayMap = pop.populateDayMap(toMonth, toYear);
        }
    }

    public void onRadioToggle(AjaxBehaviorEvent e) {
        currentOneRadioValue = !currentOneRadioValue != true;
        toDayMap = pop.populateDayMap(toMonth, toYear);

    }
    
    // GETTERS AND SETTERS
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
        return courseMap;
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
}
