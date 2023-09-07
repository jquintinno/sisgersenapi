package br.com.quintinno.sisgersenapi.utility;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class CriptografiaUtility {

    public static final String SHA_256 = "SHA-256";

    public CriptografiaUtility() { }

    public static String criptografar(String chave) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(SHA_256);
            StringBuilder chaveCriptografada = new StringBuilder();
            for (byte byt : messageDigest.digest(chave.getBytes())) {
                chaveCriptografada.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
            }
            return chaveCriptografada.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String descriptografar(String chave) {
        return CriptografiaUtility.criptografar(chave);
    }

}
