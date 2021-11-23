package com.example.ReadingIsGood.Validation;

public enum ErrorCode {
    FIRSTNAME_EMPTY("FirstName cannot be empty"),
    LASTNAME_EMPTY("LastName cannot be empty"),
    USERNAME_EMPTY("Username cannot be empty"),
    PASSWORD_EMPTY("Password cannot be empty"),
    EMAIL_EMPTY("Email cannot be empty"),
    TITTLE_EMPTY("Tittle cannot be empty"),
    PRICE_EMPTY("Price cannot be empty"),
    STOCK_EMPTY("Stock cannot be empty"),
    CUSTOMERID_EMPTY("CustomerId cannot be empty"),
    ORDERCUSTOMER_EMPTY("ORDER cannot be empty"),
    ORDERDATE_EMPTY("Order Date cannot be empty"),
    ORDERBOOKS_EMPTY("OrderBooks cannot be empty"),
    STOCK_OUTOF("Book Stock Out Of"),
    BOOK_INVALID("Book is invalid"),
    CUSTOMER_INVALID("Customer is invalid");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String message() {
        return this.message;
    }
}
