package com.uniteller.paymentprocess;

import java.io.Serializable;
import java.util.Collection;

public class ReportDto implements Serializable {
    public static final long serialVersionUID = 2954939L;

    private Collection<TransactionDetailsResponse> report;

    public Collection<TransactionDetailsResponse> getReport() {
        return report;
    }

    public void setReport(Collection<TransactionDetailsResponse> report) {
        this.report = report;
    }
}
