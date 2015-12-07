/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.user;

import afk.entities.UserEntity;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UserServiceIntf {

    //Create
    public int createUser(UserEntity user);

    //Read
    public List<UserEntity> getAll();

    public UserEntity getUserById(long id);
    
    public UserEntity getUserByName(String name);

    //Update
    public int updateUser(UserEntity user);

    //Delete
    public int deleteUser(UserEntity user);

}
