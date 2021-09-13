package com.fourstore.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="pay", url="http://localhost:8082")//, fallback = PayServiceFallback.class)
public interface PayService {

    @RequestMapping(method= RequestMethod.POST, path="/payHistories")
    public void pay(@RequestBody Pay pay);

}
