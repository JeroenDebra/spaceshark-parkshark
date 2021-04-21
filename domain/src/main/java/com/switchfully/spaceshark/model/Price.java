package com.switchfully.spaceshark.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class Price {

    @Column (name = "price_per_hour")
    private BigDecimal price;

    @Column (name = "currency")
    private String currency;

    public Price(BigDecimal price, String currency) {
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
