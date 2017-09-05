package com.e_wallet.entity.privilege;

import com.e_wallet.util.DbObjectNameUtil;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Redpike
 */
@Entity
@Table(name = DbObjectNameUtil.PRIVILEGES_TABLE, schema = DbObjectNameUtil.SCHEMA)
public class Privilege {

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

        Privilege privilege = (Privilege) o;

        if (id != null ? !id.equals(privilege.id) : privilege.id != null) return false;
        return name != null ? name.equals(privilege.name) : privilege.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Privilege{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
