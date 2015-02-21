package com.wealthmgmt.portfolio.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.joda.money.Money;
import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;

/**
 * @author: pradyumna
 * @since 1.0 21/02/2015
 */
public class SellTransaction {

    @NotEmpty
    private String stockName;
    @NotNull
    private DateTime soldOn;
    @NotNull
    private long quantity;
    @NotNull
    private Money price;

    public SellTransaction(String stockName, DateTime soldOn, long quantity, Money price) {
        this.stockName = stockName;
        this.soldOn = soldOn;
        this.quantity = quantity;
        this.price = price;
    }

}
