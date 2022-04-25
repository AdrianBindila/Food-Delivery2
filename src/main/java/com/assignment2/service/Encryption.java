package com.assignment2.service;

/**
 * The interface Encryption.
 */
public interface Encryption {
    /**
     * Encrypt string.
     *
     * @param s the s
     * @return the string
     */
    String encrypt(String s);

    /**
     * Check matching boolean.
     *
     * @param providedPassword the provided password
     * @param existingPassword the existing password
     * @return the boolean
     */
    boolean checkMatching(String providedPassword, String existingPassword);
}
