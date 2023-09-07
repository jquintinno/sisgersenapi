package br.com.quintinno.sisgersenapi.configuration;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class CriptografiaConfiguration {

    public CriptografiaConfiguration() { }

    public static String criptografar(String chave) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = messageDigest.digest(chave.getBytes());
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : bytes) {
                stringBuilder.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String descriptografar(String chave) {
        return CriptografiaConfiguration.criptografar(chave);
    }

}
