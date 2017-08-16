package com.rest.service;

import com.rest.db.Account;
import com.rest.db.EMFactory;
import com.rest.db.User;
import com.rest.db.UserTransaction;
import com.rest.exception.CustomParameterizedException;
import org.slf4j.Logger;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class TransactionService {
    private final static String CLASS = TransactionService.class.getName();
    private final static Logger LOG = org.slf4j.LoggerFactory.getLogger(CLASS);


    public static BigDecimal getBalanceByUserIdAndAccountId(Integer userId, Integer accountId) {
        BigDecimal balance = (BigDecimal) EMFactory.EM.getEntityManager().createNamedQuery("getBalanceByUserIdAndAccount")
                .setParameter("userId", userId)
                .setParameter("accountId", accountId)
                .getSingleResult();
        if (balance == null) {
            String errorMes = String.format("Error in get user balance with userId is %s and  accountId is %s ",userId,accountId);
            LOG.error(errorMes);
            throw new CustomParameterizedException(errorMes);
        }
        return balance;
    }

    public static Boolean hasPositiveBalance(Integer userId, Integer accountId, BigDecimal amount) {
        BigDecimal balance =  getBalanceByUserIdAndAccountId(userId, accountId).subtract(amount);
        if (balance.compareTo(new BigDecimal(0)) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void doTransaction(Integer senderUserId, Integer senderAccountId,Integer receiverUserId, Integer receiverAccountId, BigDecimal amount)   {
        if (hasPositiveBalance(senderUserId,senderAccountId,amount)) {
            EntityManager em = EMFactory.EM.getEntityManager();
            em.getTransaction().begin();
            User userSender = EMFactory.EM.getEntityManager().find(User.class, senderUserId);
            if (userSender == null) {
                String errorMes = String.format("User sender with id %s  not found ",senderUserId);
                LOG.error(errorMes);
                throw new CustomParameterizedException(errorMes);
            }
            User receiverUser = EMFactory.EM.getEntityManager().find(User.class, receiverUserId);
            if (receiverUser == null) {
                String errorMes = String.format("User receiver with id %s  not found ",receiverUserId);
                LOG.error(errorMes);
                throw new CustomParameterizedException(errorMes);
            }
            //
            Account accountSender = EMFactory.EM.getEntityManager().find(Account.class, senderAccountId);
            if (accountSender == null) {
                String errorMes = String.format("Account sender with id %s  not found ",senderAccountId);
                LOG.error(errorMes);
                throw new CustomParameterizedException(errorMes);
            }
            Account accountReceiver = EMFactory.EM.getEntityManager().find(Account.class, receiverAccountId);
            if (accountReceiver == null) {
                String errorMes = String.format("Account receiver with id %s  not found  ",receiverAccountId);
                LOG.error(errorMes);
                throw new CustomParameterizedException(errorMes);
            }
            //
            em.persist(new UserTransaction(userSender,accountSender,amount.negate()));
            em.persist(new UserTransaction(receiverUser,accountReceiver,amount));
            em.getTransaction().commit();
        } else {
            String errorMes = String.format("User sender with id %s  does not have enough money ",senderUserId);
            LOG.error(errorMes);
            throw new CustomParameterizedException(errorMes);
        }
    }

}
