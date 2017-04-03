package com.midtrans.sdk.core.models.merchant;

import com.midtrans.sdk.core.models.BankType;
import com.midtrans.sdk.core.models.Channel;
import com.midtrans.sdk.core.models.snap.SavedToken;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rakawm on 10/19/16.
 */

public class CreditCard implements Serializable {
    private boolean saveCard;
    private boolean secure;
    private String tokenId;
    private String channel;
    private String bank;
    private List<SavedToken> savedTokens;

    public boolean isSaveCard() {
        return saveCard;
    }

    public void setSaveCard(boolean saveCard) {
        this.saveCard = saveCard;
    }

    public boolean isSecure() {
        return secure;
    }

    public void setSecure(boolean secure) {
        this.secure = secure;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(@Channel.ChannelDef String channel) {
        this.channel = channel;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(@BankType.BankDef String bank) {
        this.bank = bank;
    }

    public List<SavedToken> getSavedTokens() {
        return savedTokens;
    }

    public void setSavedTokens(List<SavedToken> savedTokens) {
        this.savedTokens = savedTokens;
    }
}
