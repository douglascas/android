package com.tinderdog.util;

public class PasswordVerification {

    public static boolean validate(String hashed, String nonHashed){
        return hashed.equals(nonHashed);
    }
}
