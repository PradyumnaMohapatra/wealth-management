package com.wealthmgmt.core.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.axonframework.common.Assert;
import org.axonframework.domain.IdentifierFactory;

import java.io.Serializable;

/**
 * @author: pradyumna
 * @since 1.0 21/02/2015
 */
@EqualsAndHashCode
@ToString
public class PortfolioId implements Serializable {

    private String identifier;

    public PortfolioId() {
        this.identifier = IdentifierFactory.getInstance().generateIdentifier();
    }

    public PortfolioId(String identifier) {
        Assert.notNull(identifier, "Identifier may not be null");
        this.identifier = identifier;
    }

}
