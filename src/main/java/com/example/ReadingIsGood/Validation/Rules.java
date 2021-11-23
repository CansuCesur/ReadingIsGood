package com.example.ReadingIsGood.Validation;

import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Rules {

    public boolean isNull(Object item) {
        return item == null;
    }

    public boolean isEmpty(String item) {
        return item == null || item.length() == 0;
    }

    public <T> boolean isEmpty(List<T> items) {
        return items == null || items.size() == 0;
    }

    public <T> boolean isEmpty(Set<T> items) {
        return items == null || items.size() == 0;
    }

    public boolean isEmail(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\."
                + "[a-zA-Z0-9_+&*-]+)*@"
                + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(email).matches();
    }
}
