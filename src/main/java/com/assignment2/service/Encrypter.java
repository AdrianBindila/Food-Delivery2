package com.assignment2.service;

import lombok.extern.log4j.Log4j2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
@Log4j2
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
        log.info("Generated encrypted password");
        return encryptedString;
    }

    @Override
    public boolean checkMatching(String providedPassword, String existingPassword) {
        return false;
    }
}
