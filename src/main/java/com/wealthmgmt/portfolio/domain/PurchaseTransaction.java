package com.wealthmgmt.portfolio.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.joda.money.Money;
import org.joda.time.DateTime;

/**
 * @author: pradyumna
 * @since 1.0 21/02/2015
 */
@EqualsAndHashCode
@ToString()
final class PurchaseTransaction {

    private final String stockName;
    private final DateTime purchasedOn;
    private final long quantity;
    private final Money price;

    public PurchaseTransaction(String stockName, DateTime purchasedOn, long quantity, Money price) {
        this.stockName = stockName;
        this.purchasedOn = purchasedOn;
        this.quantity = quantity;
        this.price = price;
    }
}