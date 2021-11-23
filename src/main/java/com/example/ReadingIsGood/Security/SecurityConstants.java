package com.example.ReadingIsGood.Security;

public class SecurityConstants {

    public static final String SIGN_UP_URL = "/loginUsers/sign-up";
    public static final String SECRET = "EmakinaTalent";
    public static final long EXPIRATION_TIME = 864_000_000; // 5 gün
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
