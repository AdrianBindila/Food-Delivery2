package com.assignment2.service;

public interface Encryption {
    String encrypt(String s);

    boolean checkMatching(String providedPassword, String existingPassword);
}
