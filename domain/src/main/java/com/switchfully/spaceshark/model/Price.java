package com.switchfully.spaceshark.model;

import com.switchfully.spaceshark.model.parkingLot.Currency;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;


@Embeddable
public class Price {

    @Column (name = "price_per_hour")
    private BigDecimal price;

    @Column (name = "currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    public Price(BigDecimal price, Currency currency) {
        this.price = price;
        this.currency = currency;
    }

    public Price() {
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
