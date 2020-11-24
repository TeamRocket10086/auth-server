package com.bfs.authserver.dao;



import com.bfs.authserver.pojo.Role;
import com.bfs.authserver.pojo.User;
import com.bfs.authserver.pojo.UserRole;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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

//        List<User> userList = getCurrentSession().createQuery("from User").getResultList();
//        return userList.get(0);
//        String hql = "from User as user where user.username=:n";
//        Query query = getCurrentSession().createQuery(hql);
//        query.setParameter("n", name);
//        return (User) query.getResultList().get(0);
        String hql = "from User where userName = ?1";
        //Session s = sessionFactory.getCurrentSession();

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

//    public User getUserByName(String username){
//        CriteriaBuilder cb = getCurrentSession().getCriteriaBuilder();
//        CriteriaQuery<User> cq = cb.createQuery(User.class);
//
//        cq.multiselect(
//
//        );
//    }

//    public User getUserByEmail(String email) {
//        String hql = "from User where email = ?1";
//        Session s = sessionFactory.getCurrentSession();
//        Query query = s.createQuery(hql);
//        query.setParameter(1, email);
//        List<User> list = query.list();
//        if(list == null || list.size() == 0)
//            return null;
//        System.out.println("Size is " + list.size());
//        return list.get(0);
//    }

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
//    public User validateUser(String name, String email, String password) {
//        User res = null;
//        if(getUserByName(name) != null){
//            res = getUserByName(name);
//        }else{
//            res = getUserByEmail(email);
//        }
//
//        if(res != null && res.getPassword().equals(password)){
//
//            return res;
//        }
//        return null;
//    }

//    public String getRoleNameByName(String name){
//        User user = getUserByName(name);
//        Integer id = user.getId();
//        String hql = "from UserRole where UserID = ?1";
//    }

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

//    public String insert




}
