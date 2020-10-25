package com.kszu.minibank.users.server.service;

public class MaskUtils {

    public static String maskEmail(String email) {
        String maskEmailRegex = "(^[^@]{3}|(?!^)\\G)[^@]";
        String replacement = "$1*";

        return email.replaceAll(maskEmailRegex, replacement);
    }
}
