package com.goleb.wojciech.dailyDev.cryptography;

import com.goleb.wojciech.dailyDev.repository.Repository;

import javax.crypto.Cipher;
import java.security.Key;

public class CryptoRepository {
    private static final String MSG_FILE_NAME = "input.txt";
    private static final String SECURE_MSG_FILE_NAME = "output.data";
    private static final String SECURE_KEY_FILE_NAME = "secret.data";
    private static final String INITIALIZATION_VECTOR_FILE_NAME = "initializationVector.data";
    Repository repository = new Repository();
    public String getSecureKey(){
        return getStringFromTXT(SECURE_KEY_FILE_NAME);
    }
    public String getSecureMsg(){
        return getStringFromTXT(SECURE_MSG_FILE_NAME);
    }
    public String getMsg(){
        return getStringFromTXT(MSG_FILE_NAME);
    }
    public void saveSecureMsg(byte[] result){
        saveObjectToFile(result, SECURE_MSG_FILE_NAME);
    }
    public byte[] loadSecureMsg(){
        return (byte[]) getObjectFromFile(SECURE_MSG_FILE_NAME);
    }
    public void saveKey(Key key){
        saveObjectToFile(key, SECURE_KEY_FILE_NAME);
    }
    public Key loadKey (){
        return (Key) getObjectFromFile(SECURE_KEY_FILE_NAME);
    }
    private void saveObjectToFile(Object object, String fileName){
        repository.saveObjectToFile(fileName,object);
    }
    private Object getObjectFromFile (String fileName){
        return repository.loadObjectFromFile(fileName);
    }
    private void saveStringAsTXT(String string, String fileName){
        repository.printTXTToFile(string,fileName);
    }
    private String getStringFromTXT(String fileName){
        return repository.readTXTToString(fileName);
    }

    public void saveInitializationVector(byte[] initializationVector) {
        saveObjectToFile(initializationVector, INITIALIZATION_VECTOR_FILE_NAME);
    }
    public byte[] loadInitializationVector (){
        return (byte[]) getObjectFromFile(INITIALIZATION_VECTOR_FILE_NAME);
    }
}
