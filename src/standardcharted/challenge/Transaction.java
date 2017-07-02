package standardcharted.challenge;

import java.util.Date;

/**
 * Created by Harsha on 8/5/17.
 */
public class Transaction {

    private String transactionId;
    private String accountId; // Assume this is unique per transaction.
    private Date postingDate;
    private Double amount;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Date getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(Date postingDate) {
        this.postingDate = postingDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        return accountId.equals(that.accountId);

    }

    @Override
    public int hashCode() {
        return accountId.hashCode();
    }
}
