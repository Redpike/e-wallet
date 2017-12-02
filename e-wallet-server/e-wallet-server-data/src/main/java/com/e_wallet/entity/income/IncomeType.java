package com.e_wallet.entity.income;

import com.e_wallet.util.DbObjectNameUtil;
import com.e_wallet.util.enums.yes_no.YesNoEnum;
import com.e_wallet.util.enums.yes_no.YesNoEnumConverter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Redpike
 */
@Entity
@Table(name = DbObjectNameUtil.INCOME_TYPES_TABLE, schema = DbObjectNameUtil.SCHEMA)
public class IncomeType {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", precision = 3, nullable = false, unique = true)
    private Integer id;

    @NotNull
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Convert(converter = YesNoEnumConverter.class)
    @Column(name = "deleted")
    private YesNoEnum deleted;

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

    public YesNoEnum getDeleted() {
        return deleted;
    }

    public void setDeleted(YesNoEnum deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IncomeType that = (IncomeType) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return deleted == that.deleted;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (deleted != null ? deleted.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "IncomeType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
