package com.bfs.authserver.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Role", schema = "employee")
public class Role implements Serializable {
    private Integer id;
    private String roleName;
    private String description;
    private String createDate;
    private String modificationDate;
    private String lastModificationUser;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "role")
    private UserRole userRole;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "RoleName", nullable = false, length = 45)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "Description", nullable = false, length = 45)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id) &&
                Objects.equals(roleName, role.roleName) &&
                Objects.equals(description, role.description) &&
                Objects.equals(createDate, role.createDate) &&
                Objects.equals(modificationDate, role.modificationDate) &&
                Objects.equals(lastModificationUser, role.lastModificationUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleName, description, createDate, modificationDate, lastModificationUser);
    }
}
