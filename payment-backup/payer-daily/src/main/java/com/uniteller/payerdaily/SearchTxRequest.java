package com.uniteller.payerdaily;

import java.io.Serializable;

public class SearchTxRequest implements Serializable {
    public static final long serialVersionUID = 290908239L;

    private String txNumber;

    public String getTxNumber() {
        return txNumber;
    }

    public void setTxNumber(String txNumber) {
        this.txNumber = txNumber;
    }
}
