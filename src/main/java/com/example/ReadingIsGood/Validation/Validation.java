package com.example.ReadingIsGood.Validation;

public abstract class Validation extends Rules {

    private Errors errors = new Errors();

    private boolean onUpdate = false;

    public boolean passed() {
        return this.errors.all().size() == 0;
    }

    public boolean failed() {
        return this.errors.all().size() != 0;
    }

    public Errors errors() {
        return this.errors;
    }

    public Validation onUpdate() {
        this.onUpdate = true;
        return this;
    }

    public boolean isOnUpdate() {
        return onUpdate;
    }

    public abstract <T> void validate(T data);
}
