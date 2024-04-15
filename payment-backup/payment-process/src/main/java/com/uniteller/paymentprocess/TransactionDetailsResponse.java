package com.uniteller.paymentprocess;

import java.io.Serializable;

public class TransactionDetailsResponse implements Serializable {

    public static final long serialVersionUID = 854239038L;

    private String txNumber;

    private String amount;

    public String getTxNumber() {
        return txNumber;
    }

    public void setTxNumber(String txNumber) {
        this.txNumber = txNumber;
    }


    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
