package com.goleb.wojciech.dailyDev.cryptography;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;

public class DecipherClass {
    public static void main (String[] args) throws Exception{
        CryptoRepository repository = new CryptoRepository();
        Key key= repository.loadKey();
        byte[] initializationVector = repository.loadInitializationVector();
        byte[] cipheredText = repository.loadSecureMsg();
        String decipherText = doAESDecryption(cipheredText,key,initializationVector);

        System.out.println("Cipher result:");
        System.out.println(new String(cipheredText,"UTF8"));
        System.out.println("Original message:");
        System.out.println(decipherText);
    }

    private static String doAESDecryption (byte[] cipherText, Key key, byte[] initializationVector)throws Exception{
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(CipherClass.AES_CIPHER_ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initializationVector);
        cipher.init(Cipher.DECRYPT_MODE, key,ivParameterSpec);
        byte[] result = cipher.doFinal(cipherText);
        return new String(result);
    }
}
