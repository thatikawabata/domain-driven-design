package com.school.academic.infra.student;

import com.school.academic.domain.student.PasswordEncrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryptMD5 implements PasswordEncrypt {
    @Override
    public String encrypt(String password) {
        try {
            var md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            var bytes = md.digest();
            var sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("erro ao gerar hash da senha");
        }
    }

    @Override
    public boolean validatePassword(String passwordEncrypt, String password) {
        return passwordEncrypt.equals(encrypt(password));
    }
}
