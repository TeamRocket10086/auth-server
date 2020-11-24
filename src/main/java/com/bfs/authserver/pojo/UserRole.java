package com.bfs.authserver.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "UserRole", schema = "employee")
public class UserRole implements Serializable {
    private Integer id;
    private User user;
    private Role role;
    private Byte activeFlag;
    private String createDate;
    private String modificationDate;
    private String lastModificationUser;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //@Basic
    //@Column(name = "UserID")
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "UserID")
//    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID")
    public User getUser(){
        return this.user;
    }

    public void setUser(User user){
        this.user = user;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RoleID")
    public Role getRole(){
        return this.role;
    }

    public void setRole(Role role){
        this.role = role;
    }



    @Basic
    @Column(name = "ActiveFlag", nullable = false)
    public Byte getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Byte activeFlag) {
        this.activeFlag = activeFlag;
    }

    @Basic
    @Column(name = "CreateDate", nullable = false, length = 45)
    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "ModificationDate", nullable = false, length = 45)
    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

    @Basic
    @Column(name = "LastModificationUser", nullable = false, length = 45)
    public String getLastModificationUser() {
        return lastModificationUser;
    }

    public void setLastModificationUser(String lastModificationUser) {
        this.lastModificationUser = lastModificationUser;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        UserRole userRole = (UserRole) o;
//        return Objects.equals(id, userRole.id) &&
//                Objects.equals(activeFlag, userRole.activeFlag) &&
//                Objects.equals(createDate, userRole.createDate) &&
//                Objects.equals(modificationDate, userRole.modificationDate) &&
//                Objects.equals(lastModificationUser, userRole.lastModificationUser);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, activeFlag, createDate, modificationDate, lastModificationUser);
//    }
}
