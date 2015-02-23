package com.wealthmgmt.portfolio.events;

import com.wealthmgmt.core.domain.PortfolioId;
import lombok.Getter;

import java.io.Serializable;

/**
 * @author: pradyumna
 * @since 1.0 21/02/2015
 */
@Getter
public class PortfolioCreated implements Serializable {

    private PortfolioId portfolioIdentifier;

    public PortfolioCreated(PortfolioId portfolioIdentifier) {
        this.portfolioIdentifier = portfolioIdentifier;
    }
}
