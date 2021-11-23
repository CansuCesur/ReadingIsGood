package com.example.ReadingIsGood.Validation;

import com.example.ReadingIsGood.Models.Order;

public class OrderValidation extends Validation {

    @Override
    public <T> void validate(T data) {
        Order order = (Order) data;

        if (isEmpty(order.getCustomerId())) {
            this.errors().add(ErrorCode.CUSTOMERID_EMPTY);
        }

        if (isNull(order.getOrderDate())) {
            this.errors().add(ErrorCode.ORDERDATE_EMPTY);
        }

        if (isEmpty(order.getBooksId())) {
            this.errors().add(ErrorCode.ORDERBOOKS_EMPTY);
        }

    }
}
