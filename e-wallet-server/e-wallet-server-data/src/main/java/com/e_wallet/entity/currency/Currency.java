package com.e_wallet.entity.currency;

import com.e_wallet.util.DbObjectNameUtil;
import com.e_wallet.util.enums.yes_no.YesNoEnum;
import com.e_wallet.util.enums.yes_no.YesNoEnumConverter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Redpike
 */
@Entity
@Table(name = DbObjectNameUtil.CURRENCY_TABLE, schema = DbObjectNameUtil.SCHEMA)
public class Currency {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code", length = 3, nullable = false, unique = true)
    private String code;

    @NotNull
    @Column(name = "name", length = 80, nullable = false, unique = true)
    private String name;

    @NotNull
    @Column(name = "suffix", length = 3, nullable = false, unique = true)
    private String suffix;

    @Convert(converter = YesNoEnumConverter.class)
    @Column(name = "deleted")
    private YesNoEnum yesNoEnum;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
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

        Currency currency = (Currency) o;

        if (code != null ? !code.equals(currency.code) : currency.code != null) return false;
        if (name != null ? !name.equals(currency.name) : currency.name != null) return false;
        if (suffix != null ? !suffix.equals(currency.suffix) : currency.suffix != null) return false;
        return yesNoEnum == currency.yesNoEnum;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (suffix != null ? suffix.hashCode() : 0);
        result = 31 * result + (yesNoEnum != null ? yesNoEnum.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", suffix='" + suffix + '\'' +
                ", yesNoEnum=" + yesNoEnum +
                '}';
    }
}
