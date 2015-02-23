package com.wealthmgmt.core.application;

import com.wealthmgmt.core.domain.PortfolioId;
import com.wealthmgmt.portfolio.command.PortfolioCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @author: pradyumna
 * @since 1.0 21/02/2015
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.wealthmgmt.portfolio"})
@EntityScan(basePackages = {"org.axonframework.eventstore.jpa","com.wealthmgmt.portfolio.domain"})
@ImportResource(value = "classpath:axonContext.xml")
public class Application {

    private static CommandGateway commandGateway;

    protected Application() {

    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        PortfolioId portfolioId = new PortfolioId();
        commandGateway.sendAndWait(new PortfolioCommand(portfolioId));
    }

    @Autowired
    public void setCommandGateway(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }
}
