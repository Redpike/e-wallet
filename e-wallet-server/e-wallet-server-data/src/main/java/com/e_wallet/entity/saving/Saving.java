package com.e_wallet.entity.saving;

import com.e_wallet.entity.currency.Currency;
import com.e_wallet.entity.user.User;
import com.e_wallet.util.DbObjectNameUtil;
import com.e_wallet.util.enums.yes_no.YesNoEnum;
import com.e_wallet.util.enums.yes_no.YesNoEnumConverter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by Redpike
 */
@Entity
@Table(name = DbObjectNameUtil.SAVINGS_TABLE, schema = DbObjectNameUtil.SCHEMA)
public class Saving {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", precision = 9, nullable = false, unique = true)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "saving_type_id")
    private SavingType savingType;

    @OneToOne
    @JoinColumn(name = "code")
    private Currency currency;

    @NotNull
    @Column(name = "amount", precision = 17, scale = 2, nullable = false)
    private BigDecimal amount;

    @Convert(converter = YesNoEnumConverter.class)
    @Column(name = "deleted")
    private YesNoEnum deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SavingType getSavingType() {
        return savingType;
    }

    public void setSavingType(SavingType savingType) {
        this.savingType = savingType;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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

        Saving saving = (Saving) o;

        if (id != null ? !id.equals(saving.id) : saving.id != null) return false;
        if (user != null ? !user.equals(saving.user) : saving.user != null) return false;
        if (savingType != null ? !savingType.equals(saving.savingType) : saving.savingType != null) return false;
        if (currency != null ? !currency.equals(saving.currency) : saving.currency != null) return false;
        if (amount != null ? !amount.equals(saving.amount) : saving.amount != null) return false;
        return deleted == saving.deleted;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (savingType != null ? savingType.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (deleted != null ? deleted.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Saving{" +
                "id=" + id +
                ", user=" + user +
                ", savingType=" + savingType +
                ", currency=" + currency +
                ", amount=" + amount +
                ", deleted=" + deleted +
                '}';
    }
}
