package com.rest.db;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NamedQueries(value = {
    @NamedQuery(name = "getBalanceByUserIdAndAccount", query = ("SELECT SUM(t.amount) FROM UserTransaction t WHERE t.user.id =:userId and t.account.id=:accountId GROUP BY t.user, t.account"))
})
public class UserTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable = false)
    private Integer id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Account account;
    private BigDecimal amount;

    public UserTransaction( User user, Account account, BigDecimal amount) {
        this.user = user;
        this.account = account;
        this.amount = amount;
    }

    public UserTransaction() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
