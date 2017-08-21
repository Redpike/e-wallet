package com.e_wallet.entity.expense;

import com.e_wallet.entity.currency.Currency;
import com.e_wallet.entity.saving.Saving;
import com.e_wallet.entity.user.User;
import com.e_wallet.util.DbObjectNameUtil;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * Created by Redpike
 */
@Entity
@Table(name = DbObjectNameUtil.EXPENSES_TABLE, schema = DbObjectNameUtil.SCHEMA)
public class Expense {

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
    @JoinColumn(name = "id", referencedColumnName = "expense_type")
    private ExpenseType expenseType;

    @Column(name = "name", length = 80)
    private String name;

    @OneToOne
    @JoinColumn(name = "code")
    private Currency currency;

    @NotNull
    @Column(name = "amount", precision = 17, scale = 2)
    private BigDecimal amount;

    @NotNull
    @Column(name = "timestamp", columnDefinition = "DATETIME")
    private Date timestamp;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Expense expense = (Expense) o;

        if (!Objects.equals(id, expense.id)) return false;
        if (user != null ? !user.equals(expense.user) : expense.user != null) return false;
        if (saving != null ? !saving.equals(expense.saving) : expense.saving != null) return false;
        if (expenseType != null ? !expenseType.equals(expense.expenseType) : expense.expenseType != null) return false;
        if (name != null ? !name.equals(expense.name) : expense.name != null) return false;
        if (currency != null ? !currency.equals(expense.currency) : expense.currency != null) return false;
        if (amount != null ? !amount.equals(expense.amount) : expense.amount != null) return false;
        return timestamp != null ? timestamp.equals(expense.timestamp) : expense.timestamp == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (saving != null ? saving.hashCode() : 0);
        result = 31 * result + (expenseType != null ? expenseType.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", user=" + user +
                ", saving=" + saving +
                ", expenseType=" + expenseType +
                ", name='" + name + '\'' +
                ", currency=" + currency +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                '}';
    }
}
