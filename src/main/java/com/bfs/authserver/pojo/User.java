package com.bfs.authserver.pojo;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "User", schema = "employee")
public class User implements Serializable {


    private Integer id;

    private String email;
    private String password;
    private Integer personId;
    private String createDate;

    private String userName;
    private String modificationDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<UserRole> userRoleSet;

//    public UserRole getUserRole() {
//        return userRole;
//    }
//
//    public void setUserRole(UserRole userRole) {
//        this.userRole = userRole;
//    }



    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }
    //, nullable = false

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Email")
    public String getEmail() {
        return email;
    }
    //, nullable = false, length = 45

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "Password")
    public String getPassword() {
        return password;
    }
    //, nullable = false, length = 45

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "PersonID", nullable = true)
    public Integer getPersonId() {
        return personId;
    }
    //, nullable = true

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "CreateDate")
    public String getCreateDate() {
        return createDate;
    }
    //, nullable = false, length = 45

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "UserName")
    public String getUserName() {
        return userName;
    }
    //, nullable = false, length = 45

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "ModificationDate")
    public String getModificationDate() {
        return modificationDate;
    }
    //, nullable = false, length = 45

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return Objects.equals(id, user.id) &&
//                Objects.equals(email, user.email) &&
//                Objects.equals(password, user.password) &&
//                Objects.equals(personId, user.personId) &&
//                Objects.equals(createDate, user.createDate) &&
//                Objects.equals(userName, user.userName) &&
//                Objects.equals(modificationDate, user.modificationDate);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, userName, email, password, personId, createDate, modificationDate);
//    }
}
