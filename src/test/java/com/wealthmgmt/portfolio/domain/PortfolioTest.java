package com.wealthmgmt.portfolio.domain;

import com.wealthmgmt.core.domain.PortfolioId;
import com.wealthmgmt.portfolio.command.PortfolioCommand;
import com.wealthmgmt.portfolio.command.PurchaseCommand;
import com.wealthmgmt.portfolio.commandhandler.PortfolioCommandHandler;
import com.wealthmgmt.portfolio.events.PortfolioCreated;
import com.wealthmgmt.portfolio.events.PurchaseTxnAdded;
import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

/**
 * @author: pradyumna
 * @since 1.0 21/02/2015
 */
public class PortfolioTest {

    private FixtureConfiguration fixture;

    @Before
    public void setUp() {
        fixture = Fixtures.newGivenWhenThenFixture(Portfolio.class);
        PortfolioCommandHandler handler = new PortfolioCommandHandler(fixture.getRepository());
        fixture.registerAnnotatedCommandHandler(handler);
    }

    @Test
    public void testCreationOfPortfolio() {
        PortfolioId portfolioId = new PortfolioId();
        fixture.given()
                .when(new PortfolioCommand(portfolioId))
                .expectStoredEvents(new PortfolioCreated(portfolioId));
    }

    @Test
    public void testPurchaseTxnAddedToPortfolio() {
        PortfolioId portfolioId = new PortfolioId();
        DateTime dateTime = DateTime.now();
        fixture.given(new PortfolioCreated(portfolioId))
                .when(new PurchaseCommand("APPLE", dateTime, 100, Money.of(CurrencyUnit.USD, 210.34d), portfolioId))
                .expectVoidReturnType()
                .expectStoredEvents(new PurchaseTxnAdded("APPLE", dateTime, 100, Money.of(CurrencyUnit.USD, 210.34d)));
    }

}
