/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.helper;

/**
 *
 * @author c0detupus
 */
public enum DefaultUserRoles
{
    
    TEACHER("teacher");
    
    private final String role;

    private DefaultUserRoles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
    
    
    
}
