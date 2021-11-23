package com.example.ReadingIsGood.Validation;

import com.example.ReadingIsGood.Models.Book;

public class BookValidation extends Validation {

    @Override
    public <T> void validate(T data) {
        Book book = (Book) data;

        if (isEmpty(book.getTittle())) {
            this.errors().add(ErrorCode.TITTLE_EMPTY);
        }

        if (isNull(book.getPrice())) {
            this.errors().add(ErrorCode.PRICE_EMPTY);
        }

        if (isNull(book.getStock())) {
            this.errors().add(ErrorCode.STOCK_EMPTY);
        }

    }
}
