package com.e_wallet.entity.role;

import com.e_wallet.entity.group.Group;
import com.e_wallet.entity.privilege.Privilege;
import com.e_wallet.util.DbObjectNameUtil;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by Redpike
 */
@Entity
@Table(name = DbObjectNameUtil.ROLES_TABLE, schema = DbObjectNameUtil.SCHEMA)
public class Role {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", precision = 3, nullable = false, unique = true)
    private Integer id;

    @NotNull
    @Column(name = "name", length = 20, nullable = false, unique = true)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = DbObjectNameUtil.GROUPS_TABLE, joinColumns = {
            @JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "group_id")}
    )
    private Set<Group> groupSet;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = DbObjectNameUtil.PRIVILEGES_TABLE, joinColumns = {
            @JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "privilege_id")}
    )
    private Set<Privilege> privilegeSet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Group> getGroupSet() {
        return groupSet;
    }

    public void setGroupSet(Set<Group> groupSet) {
        this.groupSet = groupSet;
    }

    public Set<Privilege> getPrivilegeSet() {
        return privilegeSet;
    }

    public void setPrivilegeSet(Set<Privilege> privilegeSet) {
        this.privilegeSet = privilegeSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (id != null ? !id.equals(role.id) : role.id != null) return false;
        if (name != null ? !name.equals(role.name) : role.name != null) return false;
        if (groupSet != null ? !groupSet.equals(role.groupSet) : role.groupSet != null) return false;
        return privilegeSet != null ? privilegeSet.equals(role.privilegeSet) : role.privilegeSet == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (groupSet != null ? groupSet.hashCode() : 0);
        result = 31 * result + (privilegeSet != null ? privilegeSet.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", groupSet=" + groupSet +
                ", privilegeSet=" + privilegeSet +
                '}';
    }
}
