package model;

import java.util.List;

public class OrderService {
    private List<Order> orders;

    public Double getOrderSum() {

        return orders.stream().mapToDouble(x -> x.getSum()).reduce(0, (x, y) -> x+y);
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
