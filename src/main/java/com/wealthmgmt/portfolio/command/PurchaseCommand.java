package com.wealthmgmt.portfolio.command;

import com.wealthmgmt.core.domain.PortfolioId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.joda.money.Money;
import org.joda.time.DateTime;

/**
 * @author: pradyumna
 * @since 1.0 21/02/2015
 */
@AllArgsConstructor
@Getter
public class PurchaseCommand {

    private String stockName;
    private DateTime purchasedOn;
    private long quantity;
    private Money price;
    private PortfolioId portfolioIdentifier;


}
