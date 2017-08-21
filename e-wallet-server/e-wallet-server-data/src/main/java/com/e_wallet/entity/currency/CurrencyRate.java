package com.e_wallet.entity.currency;

import com.e_wallet.util.DbObjectNameUtil;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Redpike
 */
@Entity
@Table(name = DbObjectNameUtil.CURRENCY_RATES_TABLE, schema = DbObjectNameUtil.SCHEMA)
public class CurrencyRate {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", precision = 9, scale = 0, nullable = false, unique = true)
    private Long id;

    @OneToOne
    @JoinColumn(name = "code")
    private Currency currency;

    @NotNull
    @Column(name = "curr_rate", precision = 4, scale = 4, nullable = false)
    private BigDecimal currencyRate;

    @NotNull
    @Column(name = "timestamp", columnDefinition = "DATETIME")
    private Date timestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrencyRate that = (CurrencyRate) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        if (currencyRate != null ? !currencyRate.equals(that.currencyRate) : that.currencyRate != null) return false;
        return timestamp != null ? timestamp.equals(that.timestamp) : that.timestamp == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (currencyRate != null ? currencyRate.hashCode() : 0);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CurrencyRate{" +
                "id=" + id +
                ", currency=" + currency +
                ", currencyRate=" + currencyRate +
                ", timestamp=" + timestamp +
                '}';
    }
}
