/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.user;

import afk.entities.UserEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author valance
 */
@Stateless
public class UserServiceSLSB implements UserServiceIntf {

    @PersistenceContext(unitName = "PU")
    private EntityManager em;

    @Override
    public int createUser(UserEntity user) {
        try {
            em.persist(user);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    public List<UserEntity> getAll() {
        List<UserEntity> userList = em
                .createQuery("SELECT u FROM UserEntity AS u").getResultList();

        return userList;

    }

    @Override
    public UserEntity getUserById(long id) {
        UserEntity uTE = em.find(UserEntity.class, id);
        return uTE;
    }

    @Override
    public int updateUser(UserEntity user) {
        try {
            em.merge(user);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    public int deleteUser(UserEntity user) {
        try {
            em.remove(user);
            em.refresh(UserEntity.class);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    public UserEntity getUserByName(String name) {
        
        try {
            String qstring = "SELECT u FROM UserEntity u WHERE u.username = :name";
            TypedQuery<UserEntity> query = (TypedQuery) em.createQuery(qstring);
            query.setParameter("name", name);
            return query.getSingleResult();
        } catch (Exception e) {
        }

        return null;
    }

}
