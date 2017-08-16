package com.rest.dto;

import java.math.BigDecimal;

/**
 * Created by andrey on 09.08.2017.
 */
public class TransactionDto {
    private Integer userSenderId;
    private Integer userReciverId;
    private Integer accountSenderId;
    private Integer accountReciverId;
    private BigDecimal amount;

    public Integer getUserSenderId() {
        return userSenderId;
    }

    public void setUserSenderId(Integer userSenderId) {
        this.userSenderId = userSenderId;
    }

    public Integer getUserReciverId() {
        return userReciverId;
    }

    public void setUserReciverId(Integer userReciverId) {
        this.userReciverId = userReciverId;
    }

    public Integer getAccountSenderId() {
        return accountSenderId;
    }

    public void setAccountSenderId(Integer accountSenderId) {
        this.accountSenderId = accountSenderId;
    }

    public Integer getAccountReciverId() {
        return accountReciverId;
    }

    public void setAccountReciverId(Integer accountReciverId) {
        this.accountReciverId = accountReciverId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "userSenderId=" + userSenderId +
                ", userReciverId=" + userReciverId +
                ", accountSenderId=" + accountSenderId +
                ", accountReciverId=" + accountReciverId +
                ", amount=" + amount +
                '}';
    }
}
