package com.uniteller.payerdaily;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/*@FeignClient(url="http://localhost:8443", value = "payment-process")*/
@FeignClient(name = "PAYMENT-PROCESS")
public interface PaymentProcessClient {

    @PostMapping("/getAllTransaction")
    ReportDto getReport(@RequestBody SearchTxRequest txRequest);

    @PostMapping("/getAllTransaction1")
    ReportDto getReport1(@RequestBody SearchTxRequest txRequest);
}
