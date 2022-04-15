package com.assignment2.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypter implements Encryption {

    @Override
    public String encrypt(String s) {
        String encryptedString="";
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(s.getBytes());
            byte[] bytes = m.digest();

            StringBuilder sb = new StringBuilder();
            for(byte b:bytes){
                sb.append(String.format("%02X",b));
            }
            encryptedString= String.valueOf(sb);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return encryptedString;
    }

    @Override
    public boolean checkMatching(String providedPassword, String existingPassword) {
        return false;
    }
}
