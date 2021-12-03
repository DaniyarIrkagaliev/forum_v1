package com.company.pages;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

//можно не хэшировать
public class Password {

//    public static String generatePasswordHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
//        //TODO СПРОСИТЬ: ХРАНИТЬ ТАК СОЛЬ И ИТЕРАЦИИ МОЖНО ИЛИ ЛУЧШЕ ПУСТЬ ОНИ БУДУТ КАК СТАТИЧЕСКИЕ ПЕРЕМЕННЫЕ,
//        // А СОЛЬ НЕ ГЕНЕРИТСЯ КАЖДЫЙ РАЗ
//        int iterations = 100;
//        char[] chars = password.toCharArray();
//        byte[] salt = getSalt();
//
//        PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
//        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
//
//        byte[] hash = skf.generateSecret(spec).getEncoded();
//        return iterations + ":" + toHex(salt) + ":" + toHex(hash);
//    }
//
//    private static byte[] getSalt() throws NoSuchAlgorithmException {
//        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
//        byte[] salt = new byte[16];
//        sr.nextBytes(salt);
//        return salt;
//    }
//
//    private static String toHex(byte[] array) {
//        BigInteger bi = new BigInteger(1, array);
//        String hex = bi.toString(16);
//
//        int paddingLength = (array.length * 2) - hex.length();
//        if (paddingLength > 0) {
//            return String.format("%0" + paddingLength + "d", 0) + hex;
//        } else {
//            return hex;
//        }
//    }
//private static byte[] fromHex(String hex) {
//        byte[] bytes = new byte[hex.length() / 2];
//        for (int i = 0; i < bytes.length; i++) {
//            bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
//        }
//        return bytes;
//    }

    public static boolean validatePassword(String originalPassword, String storedPassword) {
        if (originalPassword.equals(storedPassword)) {
            return true;
        } else {
            return false;
        }
    }

}
