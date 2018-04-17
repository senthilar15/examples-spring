package com.test.jpa.infra;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

@Component
public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver {
    
    @Override
    public String resolveCurrentTenantIdentifier() {
        return TenantHolder.currentTenant();
    }
   
   
    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }

}
