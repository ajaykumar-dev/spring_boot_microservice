package com.uniteller.paymentprocess;

import com.uniteller.paymentprocess.ReportDto;
import com.uniteller.paymentprocess.SearchTxRequest;
import com.uniteller.paymentprocess.TransactionDetailsResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PaymentProcessRestController {

    static Map<String, TransactionDetailsResponse>allPaidTxs=new HashMap<>();

    @PostMapping("/getTransaction")
    public TransactionDetailsResponse getTransaction(@RequestBody SearchTxRequest searchTxRequest){
        TransactionDetailsResponse transactionDetailsResponse=new TransactionDetailsResponse();
        transactionDetailsResponse.setTxNumber(searchTxRequest.getTxNumber());
        transactionDetailsResponse.setAmount(String.valueOf(Calendar.getInstance().getTime().getTime()));
        allPaidTxs.put(searchTxRequest.getTxNumber(), transactionDetailsResponse);
        return transactionDetailsResponse;
    }

    @PostMapping("/getAllTransaction")
    public ReportDto payTransaction(@RequestBody SearchTxRequest searchTxRequest){
        ReportDto rr=new ReportDto();
        rr.setReport(allPaidTxs.values());
        return rr;
    }

    @PostMapping("/getAllTransaction1")
    public ReportDto payTransaction1(@RequestBody SearchTxRequest searchTxRequest){
        ReportDto rr=new ReportDto();
        rr.setReport(allPaidTxs.values());
        return rr;
    }


}
