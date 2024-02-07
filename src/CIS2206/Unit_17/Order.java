package CIS2206.Unit_17;

import java.util.Objects;

public class Order {
    String orderID;
    String productName;
    Integer productPrice;
    Integer quantity;
    String status;

    public Order(String orderID,String productName, Integer productPrice, Integer quantity, String status) {
        this.orderID = orderID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        if (status.equalsIgnoreCase("PENDING") || status.equalsIgnoreCase("PAID") ||
                status.equalsIgnoreCase("SHIPPED") || status.equalsIgnoreCase("DELIVERED") ||
                status.equalsIgnoreCase("REFUNDED")) {
            this.status = status;
        } else {
            // If the provided status is not allowed, set a default status PENDING
            System.out.println("Invalid status, setting to default (PENDING)");
            this.status = "PENDING";
        }

//        this.status = status;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    /**
     * This method creates a String representation of
     * the object in a human friendly fashion.
     *
     * @return A String representation of the person
     */
    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", quantity='" + quantity + '\'' +
                ", status=" + status +
                "}\n";
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Order person = (Order) o;
//        return Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(age, person.age);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, surname, age);
//    }
}
