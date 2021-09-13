package com.fourstore.order.external;

import org.springframework.stereotype.Service;

@Service
public class PayServiceFallback implements PayService {
    @Override
    public void pay(Pay order) {
        
        System.out.println("######################################");
        System.out.println("Circuit breaker has been opened. Fallback returned instead.");
    }
}
