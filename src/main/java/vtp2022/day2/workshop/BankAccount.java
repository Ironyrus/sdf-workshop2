/*
PS C:\Users\vans_\sdf-workshop1> git add . (add ALL content of cart to github)
git commit -m "While Loop"                  (add comment while committing)
git push origin main                        (push to main branch)
*/

//highlight variable and right-click > source action > generate getters and setters

package vtp2022.day2.workshop;

import java.util.*;
import java.time.*;

public class BankAccount {
    private final String name;
    private String acctId = UUID.randomUUID()
                            .toString()
                            .substring(0, 8);
    private float balance = 0f;
    private List<String> transaction = new LinkedList<>();
    private boolean isClosed = false;
    private LocalDate accountCreationDate;
    private LocalDate accountClosingDate;

    public BankAccount(String name) {
        this.name = name;
        this.balance = 0;
    }

    public BankAccount(String name, float initialBal) {
        this.name = name;
        this.balance = initialBal;
    }

    public String getName() {
        return name;
    }

    public String getAcctId() {
        return acctId;
    }

    public float getBalance() {
        return balance;
    }
    public void setBalance(float balance) {
        this.balance = balance;
    }

    public List<String> getTransaction() {
        return transaction;
    }
    public void setTransaction(List<String> transaction) {
        this.transaction = transaction;
    }

    public LocalDate getAccountCreationDate() {
        return accountCreationDate;
    }
    public void setAccountCreationDate(LocalDate creationDate) {
        this.accountCreationDate = creationDate;
    }

    public LocalDate getAccountClosingDate() {
        return accountClosingDate;
    }
    public void setAccountClosingDate(LocalDate creationDate) {
        this.accountClosingDate = creationDate;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void deposit(String depositAmt) {
        try {
            Float depositAmtF = Float.parseFloat(depositAmt); //to detect wrongful input eg alphabets
            if (depositAmtF.floatValue() <= 0)
                throw new IllegalArgumentException("Invalid deposit amount. Amount cannot be negative.");
            if (this.isClosed())
                throw new IllegalArgumentException("Account is closed.");
           
            this.balance = this.balance + depositAmtF.floatValue();
            //Construct the transaction history event log
            StringBuilder txnStrbld = new StringBuilder();
            txnStrbld.append("Deposit $");
            txnStrbld.append(depositAmtF.floatValue());
            txnStrbld.append(" at ");
            txnStrbld.append(LocalDateTime.now());
            System.out.println(txnStrbld.toString());
            //Saving the event log
            transaction.add(txnStrbld.toString());
            System.out.println("New account balance: " + this.balance);

        } catch (NumberFormatException e) {
            System.err.print(e);
            throw new IllegalArgumentException("Invalid deposit amount.");
        }
        
    }

    public float withdraw(String withdrawAmt) {
        Float withdrawAmtF = null;
        try {
            withdrawAmtF = Float.parseFloat(withdrawAmt); //to detect wrongful input eg alphabets
            if (withdrawAmtF.floatValue() <= 0)
                throw new IllegalArgumentException("Invalid withdrawal amount. Amount cannot be negative.");
            if (this.isClosed())
                throw new IllegalArgumentException("Account is closed.");
           
            this.balance = this.balance - withdrawAmtF.floatValue();
            //Construct the transaction history event log
            StringBuilder txnStrbld = new StringBuilder();
            txnStrbld.append("Withdraw $");
            txnStrbld.append(withdrawAmtF.floatValue());
            txnStrbld.append(" at ");
            txnStrbld.append(LocalDateTime.now());
            System.out.println(txnStrbld.toString());
            //Saving the event log
            transaction.add(txnStrbld.toString());
            System.out.println("New account balance: " + this.balance);

        } catch (NumberFormatException e) {
            System.err.print(e);
            throw new IllegalArgumentException("Invalid withdrawal amount.");
        }
        return withdrawAmtF.floatValue();
    }
}
