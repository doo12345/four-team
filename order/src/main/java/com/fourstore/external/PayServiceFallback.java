package com.fourstore.external;

public class PayServiceFallback implements PayService {
    @Override
    public void pay(Pay order) {
        
        System.out.println("######################################");
        System.out.println("Circuit breaker has been opened. Fallback returned instead.");
    }
}
