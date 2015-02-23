package com.wealthmgmt.portfolio.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.joda.money.Money;
import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * @author: pradyumna
 * @since 1.0 21/02/2015
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PurchaseTxnAdded implements Serializable {

    private String stockName;
    private DateTime purchasedOn;
    private long quantity;
    private Money price;
}
