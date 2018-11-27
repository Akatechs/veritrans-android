package com.midtrans.sdk.corekit.core.merchant.model.checkout.request.specific.banktransfer;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BankTransferVirtualAccount implements Serializable {
    @SerializedName("va_number")
    private String vaNumber;

    public BankTransferVirtualAccount() {
    }

    public BankTransferVirtualAccount(String vaNumber) {
        setVaNumber(vaNumber);
    }

    public String getVaNumber() {
        return vaNumber;
    }

    public void setVaNumber(String vaNumber) {
        this.vaNumber = vaNumber;
    }
}