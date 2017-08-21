package com.e_wallet.entity.role;

import com.e_wallet.util.DbObjectNameUtil;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (id != null ? !id.equals(role.id) : role.id != null) return false;
        return name != null ? name.equals(role.name) : role.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
