package model;

public class Order {

    String title;
    double sum;

    public String getTitle() {
        return title;
    }

    public Order(String title, double sum) {
        this.sum = sum;
        this.title = title;
    }

    public double getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "Order{" +
                "title='" + title + '\'' +
                ", sum=" + sum +
                '}';
    }
}
