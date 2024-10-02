package cleancode.day04;

import java.util.List;

public class Order {

    private final List<Item> orderItems;
    private final Customer customer;

    public Order(List<Item> orderItems, Customer customer) {
        this.orderItems = orderItems;
        this.customer = customer;
    }

    public void validate() {
        if (hasOrderItem()) {
            throw new IllegalArgumentException("주문 항목이 없습니다.");
        }

        if (hasTotalPrice()) {
            throw new IllegalArgumentException("올바르지 않은 총 가격입니다.");
        }

        if (emptyCustomerInfo()) {
            throw new IllegalArgumentException("사용자 정보가 없습니다.");
        }
    }

    private int getTotalPrice() {
        return orderItems.stream()
        .mapToInt(Item::price)
        .sum();
    }

    private boolean hasCustomerInfo() {
        return customer != null;
    }

    private boolean emptyCustomerInfo() {
        return !hasCustomerInfo();
    }

    private boolean hasTotalPrice() {
        return getTotalPrice() <= 0;
    }

    private boolean hasOrderItem() {
        return orderItems == null || orderItems.isEmpty();
    }
}
