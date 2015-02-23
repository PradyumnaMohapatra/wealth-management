package com.wealthmgmt.portfolio.domain;

import com.wealthmgmt.core.domain.PortfolioId;
import com.wealthmgmt.portfolio.events.PortfolioCreated;
import com.wealthmgmt.portfolio.events.PurchaseTxnAdded;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * This class is an glove to hold all the stocks that
 * are owned by an individual.
 *
 * @author: pradyumna
 * @since 1.0 21/02/2015
 */
@Entity
public class Portfolio extends AbstractAnnotatedAggregateRoot<PortfolioId> {

    @Transient
    private Collection<PurchaseTransaction> purchaseTransactions;
    @Transient
    private Money totalInvestment;
    @Transient
    private Collection<SellTransaction> sellTransactions;

    @EmbeddedId
    @AggregateIdentifier
    private PortfolioId portfolioIdentifier;

    protected Portfolio() {
    }

    public Portfolio(PortfolioId portfolioIdentifier) {
        apply(new PortfolioCreated(portfolioIdentifier));
    }

    @EventHandler
    protected void handle(PortfolioCreated event) {
        this.portfolioIdentifier = event.getPortfolioIdentifier();
        totalInvestment = Money.of(CurrencyUnit.USD, BigDecimal.ZERO);
    }

    @EventHandler
    private void handle(PurchaseTxnAdded event) {
        if (purchaseTransactions == null) {
            purchaseTransactions = new LinkedHashSet<>();
        }
        purchaseTransactions.add(new PurchaseTransaction(event.getStockName(), event.getPurchasedOn(),
                event.getQuantity(), event.getPrice()));
        totalInvestment = totalInvestment.plus(event.getPrice().getAmount());
    }

    @Override
    public PortfolioId getIdentifier() {
        return portfolioIdentifier;
    }

    public void addPurchaseTransaction(String stockName, DateTime purchasedOn, long quantity, Money price) {
        apply(new PurchaseTxnAdded(stockName, purchasedOn, quantity, price));
    }
}
