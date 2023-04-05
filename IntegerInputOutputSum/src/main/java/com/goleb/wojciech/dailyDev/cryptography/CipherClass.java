package com.goleb.wojciech.dailyDev.cryptography;

import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class CipherClass {

    public static final String AES_CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";
    public static final String AES = "AES";

    public static void main (String[] args) throws Exception{
        CryptoRepository repository = new CryptoRepository();
        Key key = createKey(repository);
        String msg = repository.getMsg();
        byte[] initializationVector = createInitializationVector(repository);
        byte[] cipherText = doAESEncryption(msg,key,initializationVector);
        repository.saveSecureMsg(cipherText);

        System.out.println("Original message:");
        System.out.println(msg);
        System.out.println("Cipher result:");
        System.out.println(new String(cipherText,"UTF8"));
    }
    private static byte[] doAESEncryption (String msg, Key key, byte[] initializationVector) throws Exception{
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(AES_CIPHER_ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initializationVector);
        cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, key,ivParameterSpec);
        return cipher.doFinal(msg.getBytes());
    }
    private static byte[] createInitializationVector(CryptoRepository repository) {
        byte[] initializationVector =new byte[16];
        SecureRandom secureRandom =new SecureRandom();
        secureRandom.nextBytes(initializationVector);
        repository.saveInitializationVector(initializationVector);
        return initializationVector;
    }

    private static Key createKey(CryptoRepository repository) throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance(AES);
        SecureRandom secRandom = new SecureRandom();
        keyGen.init(256, secRandom);
        Key key= keyGen.generateKey();
        repository.saveKey(key);
        return key;
    }
}
