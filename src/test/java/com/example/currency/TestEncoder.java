package com.example.currency;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestEncoder {

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("1212"));
    }
}
