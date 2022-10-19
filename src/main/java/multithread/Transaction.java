package multithread;

public class Transaction {

    private Account from;
    private Account to;

    public Transaction(Account from, Account to) {
        this.from = from;
        this.to = to;
    }

    public Account getFrom() {
        return from;
    }

    public void setFrom(Account from) {
        this.from = from;
    }

    public Account getTo() {
        return to;
    }

    public void setTo(Account to) {
        this.to = to;
    }
}
