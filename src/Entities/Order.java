package Entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import Entities.Enums.OrderStatus;

public class Order {

	DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private LocalDateTime moment;
    private OrderStatus status;
    private List<OrderItem> items = new ArrayList<>();

    public Order() {
    }

    public Order(LocalDateTime moment, OrderStatus status) {
        this.moment = moment;
        this.status = status;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMMARY\n");
        sb.append("Order moment: ").append(moment.format(formato2)).append("\n");
        sb.append("Order Status: ").append(status).append("\n");
        sb.append("Order Items:\n");
        for (OrderItem item : items) {
            sb.append(item.toString());
        }
        return sb.toString();
    }
}
