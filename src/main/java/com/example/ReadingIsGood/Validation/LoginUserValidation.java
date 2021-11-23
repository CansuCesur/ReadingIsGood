package com.example.ReadingIsGood.Validation;

import com.example.ReadingIsGood.Models.LoginUser;

public class LoginUserValidation extends Validation {

    @Override
    public <T> void validate(T data) {
        LoginUser loginUser = (LoginUser) data;

        if (isEmpty(loginUser.getUsername())) {
            this.errors().add(ErrorCode.USERNAME_EMPTY);
        }
        if (isEmpty(loginUser.getPassword())) {
            this.errors().add(ErrorCode.PASSWORD_EMPTY);
        }

    }
}
