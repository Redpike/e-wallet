package com.e_wallet.entity.expense;

import com.e_wallet.util.DbObjectNameUtil;
import com.e_wallet.util.enums.yes_no.YesNoEnum;
import com.e_wallet.util.enums.yes_no.YesNoEnumConverter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Redpike
 */
@Entity
@Table(name = DbObjectNameUtil.EXPENSE_TYPES_TABLE, schema = DbObjectNameUtil.SCHEMA)
public class ExpenseType {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", precision = 3, nullable = false, unique = true)
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Convert(converter = YesNoEnumConverter.class)
    @Column(name = "deleted")
    private YesNoEnum yesNoEnum;

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

    public YesNoEnum getYesNoEnum() {
        return yesNoEnum;
    }

    public void setYesNoEnum(YesNoEnum yesNoEnum) {
        this.yesNoEnum = yesNoEnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExpenseType that = (ExpenseType) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return yesNoEnum == that.yesNoEnum;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (yesNoEnum != null ? yesNoEnum.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ExpenseType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yesNoEnum=" + yesNoEnum +
                '}';
    }
}
