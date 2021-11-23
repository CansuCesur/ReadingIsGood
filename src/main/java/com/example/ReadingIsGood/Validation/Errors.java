package com.example.ReadingIsGood.Validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Errors {

    private List<ErrorCode> errors;

    public Errors() {
        this.errors = new ArrayList<ErrorCode>();
    }

    public Errors add(ErrorCode e) {
        if (this.errors == null) {
            this.errors = new ArrayList<ErrorCode>();
        }

        this.errors.add(e);
        return this;
    }

    public ErrorCode get(String key) {
        return this.errors != null ? this.errors.stream().filter(e -> e.name().equals(key)).findFirst().get() : null;
    }

    public ErrorCode get(ErrorCode code) {
        return this.errors != null ? this.errors.stream().filter(e -> e.equals(code)).findFirst().get() : null;
    }

    public List<ErrorCode> all() {
        return this.errors;
    }

    public boolean has(String key) {
        return this.errors != null ? this.errors.stream().anyMatch(e -> e.name().equals(key)) : false;
    }

    public boolean has(ErrorCode code) {
        return this.errors != null ? this.errors.stream().anyMatch(e -> e.equals(code)) : false;
    }

    public boolean has(String[] keys) {
        return this.errors != null ? Arrays.stream(keys).anyMatch(key -> this.has(key)) : false;
    }

    public boolean any() {
        return !this.errors.isEmpty();
    }

    public void clear() {
        this.errors.clear();
    }
}
