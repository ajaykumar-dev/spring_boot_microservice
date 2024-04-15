package com.uniteller.payerdaily;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.*;

@RestController
public class PayerDailyController {

    private Logger logger= LoggerFactory.getLogger(PayerDailyController.class);

    @Autowired
    @Qualifier(value = "TxServiceClient")
    private WebClient webClient;


    @Autowired
    private PaymentProcessClient paymentProcessClient;


    @PostMapping("/getPayerDailyReport")
    public ReportDto payTransaction(String date){
        SearchTxRequest aa=new SearchTxRequest();
        aa.setTxNumber("242343");
        System.out.println("  "+date);
        ReportDto reportDto=paymentProcessClient.getReport(aa);
        return reportDto;
    }

    @PostMapping("/getPayerDailyReport1")
    @CircuitBreaker(name = "getTransactionBreaker1", fallbackMethod = "getTransactionFallback1")
    public ReportDto payTransaction1(String date){
        SearchTxRequest aa=new SearchTxRequest();
        aa.setTxNumber("242343");
        ReportDto reportDto=paymentProcessClient.getReport1(aa);
        return reportDto;
    }
    @PostMapping("/getPayerDailyReport2")
    @Retry(name = "getTransactionBreaker2", fallbackMethod = "getTransactionFallback2" )
    public ReportDto payTransaction2(String date){
        SearchTxRequest aa=new SearchTxRequest();
        aa.setTxNumber("242343");
        System.out.println("--retry 1----   time "+new Date());
        ReportDto reportDto=paymentProcessClient.getReport1(aa);
        return reportDto;
    }

    public ReportDto getTransactionFallback1(String date, Exception ex){
        logger.debug("--------- testing fallback --------- {}", ex);
        ReportDto rr=new ReportDto();
        List<TransactionDetailsResponse> asa;
        asa = new ArrayList<>();
        TransactionDetailsResponse sa=new TransactionDetailsResponse();
        sa.setTxNumber("fallback1");
        sa.setAmount("323");
        asa.add(sa);
        rr.setReport(asa);
        return rr;
    }

    public ReportDto getTransactionFallback2(String date, Exception ex){
        logger.debug("--------- testing fallback --------- {}", ex);
        ReportDto rr=new ReportDto();
        List<TransactionDetailsResponse> asa;
        asa = new ArrayList<>();
        TransactionDetailsResponse sa=new TransactionDetailsResponse();
        sa.setTxNumber("fallback2");
        sa.setAmount("323");
        asa.add(sa);
        rr.setReport(asa);
        return rr;
    }


   /* @PostMapping("/getPayerDailyReport")
    public Mono<ReportDto> payTransaction(String date){
        SearchTxRequest aa=new SearchTxRequest();
        aa.setTxNumber("242343");
        System.out.println("  "+date);
        Mono<ReportDto> rr=webClient.post().uri("/getAllTransaction")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(aa), SearchTxRequest.class)
                .retrieve()
                .bodyToMono(ReportDto.class);
        return rr;
    }*/

}
