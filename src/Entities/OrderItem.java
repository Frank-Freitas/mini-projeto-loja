package Entities;

import java.util.ArrayList;
import java.util.List;

public class OrderItem {

    private Integer quantity;
    private Double price;
    private List<Product> productList = new ArrayList<>();

    public OrderItem() {
    }

    public OrderItem(Integer quantity, Double price) {
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double subTotal() {
        return quantity * price;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void removeProduct(Product product) {
        productList.remove(product);
    }

    @Override
    public String toString() {
        Double totalprice = 0.0;
        StringBuilder sb = new StringBuilder();
        for (Product product : productList) {
            sb.append(product.toString()).append(", ");
            totalprice += product.getPrice();
        }

       
        if (!productList.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }

      
        sb.append(", " +price)
          .append(", Quantity: ").append(quantity)
          .append(", Subtotal: ").append(subTotal() + "\n");
        
        return sb.toString();
    }
}
