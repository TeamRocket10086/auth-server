package com.bfs.authserver.dao;



import com.bfs.authserver.pojo.Role;
import com.bfs.authserver.pojo.User;
import com.bfs.authserver.pojo.UserRole;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.time.LocalDate;
import java.util.List;

@Repository("userDao")
public class UserDAO extends AbstractHibernateDAO<User> {
    public UserDAO() {
        setClazz(User.class);
    }

    public User getUserById(Integer id) {
        return findById(id);
    }

    public User getUserByName(String name) {

        String hql = "from User where userName = ?1";

        Session s = getCurrentSession();
        Query query = s.createQuery(hql);
        query.setParameter(1, name);
        List<User> list = query.getResultList();
        if(list == null || list.size() == 0)
            return null;
        System.out.println("Size is " + list.size());
        return list.get(0);
    }

    public User getUserByEmail(String email) {

        String hql = "from User where email = ?1";
        Session s = sessionFactory.getCurrentSession();
        Query query = s.createQuery(hql);
        query.setParameter(1, email);
        List<User> list = query.getResultList();
        if(list == null || list.size() == 0)
            return null;
        System.out.println("Size is " + list.size());
        return list.get(0);
    }


    public User validateUser(String name, String pass) {

        User res = null;
        res = getUserByName(name);
        if(res != null){
            if(res.getPassword().equals(pass)) {
                return res;
            }
            else
                return null;
        }
        return res;
    }


    public Role getRoleByUser(User user){

        String hql = "from UserRole where user = ?1";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter(1, user);
        UserRole userRole = (UserRole) query.getResultList().get(0);

        return userRole.getRole();
    }

    public String getRoleNameByRole(Role role){
        return role.getRoleName();
    }

    public Role getRoleByRoleName(String roleName){

        String hql = "from Role where roleName = ?1";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter(1, roleName);
        List<Role> list = query.getResultList();
        if(list == null ||list.size() == 0){
            return null;
        }
        return list.get(0);
    }

    public void createUser(User user){

        LocalDate date = LocalDate.now();
        user.setCreateDate(date.toString());
        user.setModificationDate(date.toString());

//        Role role = new Role();
//        role.setRoleName("EMPLOYEE");
//        role.setDescription("EMPLOYEE");
//        role.setCreateDate(date.toString());
//        role.setModificationDate(date.toString());
//        role.setLastModificationUser("Register Employee");
        Role role = getRoleByRoleName("EMPLOYEE");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        userRole.setActiveFlag((byte) 1);
        userRole.setCreateDate(date.toString());
        userRole.setModificationDate(date.toString());
        userRole.setLastModificationUser("Register Employee");

        //getCurrentSession().save("Role", role);
        getCurrentSession().save("User", user);
        getCurrentSession().save("UserRole", userRole);
        //return userId;
    }




}
