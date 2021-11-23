package com.example.ReadingIsGood.Validation;

import com.example.ReadingIsGood.Models.Customer;

public class CustomerValidation extends Validation {

    @Override
    public <T> void validate(T data) {
        Customer customer = (Customer) data;

        if (isEmpty(customer.getFirstName())) {
            this.errors().add(ErrorCode.FIRSTNAME_EMPTY);
        }

        if (isEmpty(customer.getLastName())) {
            this.errors().add(ErrorCode.LASTNAME_EMPTY);
        }

        if (isEmpty(customer.getUserName())) {
            this.errors().add(ErrorCode.USERNAME_EMPTY);
        }
        if (isEmpty(customer.getPassword())) {
            this.errors().add(ErrorCode.PASSWORD_EMPTY);
        }

        if (isEmpty(customer.getEmail())) {
            this.errors().add(ErrorCode.EMAIL_EMPTY);
        }

    }
}
