/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author c0detupus
 */
@Entity
@Table(name = "Course")
public class CourseEntity implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_id")
    private long id;

    @Column(name = "name")
    private String name;
    
    @Column(name = "code")
    private String code;
    
    @Column(name = "points")
    private String points;

    public CourseEntity() {

    }

    //SETTERS----->
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPoints(String points) {
        this.points = points;
    }
    //<-----SETTERS

    //GETTERS----->
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getPoints() {
        return points;
    }
    //<-----GETTERS

}
