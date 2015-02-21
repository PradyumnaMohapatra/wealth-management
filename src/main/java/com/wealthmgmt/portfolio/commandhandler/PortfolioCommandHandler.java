package com.wealthmgmt.portfolio.commandhandler;

import com.wealthmgmt.portfolio.command.PortfolioCommand;
import com.wealthmgmt.portfolio.command.PurchaseCommand;
import com.wealthmgmt.portfolio.domain.Portfolio;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.axonframework.unitofwork.UnitOfWork;

/**
 * @author: pradyumna
 * @since 1.0 21/02/2015
 */
@AllArgsConstructor
public class PortfolioCommandHandler {

    private final String COMMAND_NAME = "PORTFOLIO_CREATION";
    private Repository<Portfolio> portfolioRepository;


    @CommandHandler
    public void handlePortfolioCommand(PortfolioCommand command){
        Portfolio portfolio = new Portfolio(command.getId());
        portfolioRepository.add(portfolio);
    }

    @CommandHandler
    public void handlePurchaseTxnAddCommand(PurchaseCommand command){
        Portfolio portfolio = portfolioRepository.load(command.getPortfolioIdentifier());
        portfolio.addPurchaseTransaction(command.getStockName(),command.getPurchasedOn(),command.getQuantity(),command.getPrice());
    }
}
