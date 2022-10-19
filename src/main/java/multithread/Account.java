package multithread;

public class Account {

    private int number;
    private int sum;

    public Account(int sum, int number) {
        this.sum = sum;
        this.number = number;
    }

    public int getSum() {
        return sum;
    }

    public int getNumber() {
        return number;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
