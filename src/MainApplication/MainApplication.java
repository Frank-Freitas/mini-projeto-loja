package MainApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Entities.Client;
import Entities.Order;
import Entities.OrderItem;
import Entities.Product;
import Entities.Enums.OrderStatus;

public class MainApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String name, email, birthDateStr, productName, status;
        int manyItems, quantity;
        Double productPrice;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter client data");
        System.out.print("Name: ");
        name = scanner.nextLine();
        System.out.print("Email: ");
        email = scanner.nextLine();
        System.out.print("Birth Date (DD/MM/YYYY): ");
        birthDateStr = scanner.nextLine();
        LocalDate date2 = LocalDate.parse(birthDateStr, formatter);
        Client client = new Client(name, email, date2);

        System.out.println("Enter order data");
        System.out.print("Status: ");
        status = scanner.nextLine();

        LocalDateTime date = LocalDateTime.now();
        Order order = new Order(date, OrderStatus.valueOf(status));

        System.out.print("How many items to this order? ");
        manyItems = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= manyItems; i++) {
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            productName = scanner.nextLine();
            System.out.print("Product price: ");
            productPrice = scanner.nextDouble();
            System.out.print("Quantity: ");
            quantity = scanner.nextInt();
            scanner.nextLine();
            Product product = new Product(productName, productPrice);
            OrderItem orderItem = new OrderItem(quantity, productPrice);
            orderItem.addProduct(product);

            order.addItem(orderItem);
        }
        
        System.out.println(order.toString());
        System.out.println(client.toString());
        
        scanner.close();
    }
}
