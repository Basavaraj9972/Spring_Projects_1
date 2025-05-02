package com.tap.utils;

public class AuthUtils {

    // Example method to authenticate user (for demonstration purposes)
    public static boolean authenticate(String loginId, String password) {
        // Example credentials, should be replaced with real authentication logic
        String validLoginId = "test@sunbasedata.com";
        String validPassword = "Test@123";

        return loginId.equals(validLoginId) && password.equals(validPassword);
    }
}
