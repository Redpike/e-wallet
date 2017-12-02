package com.e_wallet.entity.income;

import com.e_wallet.entity.currency.Currency;
import com.e_wallet.entity.saving.Saving;
import com.e_wallet.entity.user.User;
import com.e_wallet.util.DbObjectNameUtil;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Redpike
 */
@Entity
@Table(name = DbObjectNameUtil.INCOMES_TABLE, schema = DbObjectNameUtil.SCHEMA)
public class Income {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", precision = 9, nullable = false, unique = true)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "saving_id")
    private Saving saving;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "income_type_id")
    private IncomeType incomeType;

    @Column(name = "name", length = 80)
    private String name;

    @OneToOne
    @JoinColumn(name = "code")
    private Currency currency;

    @NotNull
    @Column(name = "amount", precision = 17, scale = 2, nullable = false)
    private BigDecimal amount;

    @NotNull
    @Column(name = "timestamp", columnDefinition = "DATETIME", nullable = false)
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Saving getSaving() {
        return saving;
    }

    public void setSaving(Saving saving) {
        this.saving = saving;
    }

    public IncomeType getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(IncomeType incomeType) {
        this.incomeType = incomeType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Income income = (Income) o;

        if (id != null ? !id.equals(income.id) : income.id != null) return false;
        if (user != null ? !user.equals(income.user) : income.user != null) return false;
        if (saving != null ? !saving.equals(income.saving) : income.saving != null) return false;
        if (incomeType != null ? !incomeType.equals(income.incomeType) : income.incomeType != null) return false;
        if (name != null ? !name.equals(income.name) : income.name != null) return false;
        if (currency != null ? !currency.equals(income.currency) : income.currency != null) return false;
        if (amount != null ? !amount.equals(income.amount) : income.amount != null) return false;
        return date != null ? date.equals(income.date) : income.date == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (saving != null ? saving.hashCode() : 0);
        result = 31 * result + (incomeType != null ? incomeType.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Income{" +
                "id=" + id +
                ", user=" + user +
                ", saving=" + saving +
                ", incomeType=" + incomeType +
                ", name='" + name + '\'' +
                ", currency=" + currency +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
