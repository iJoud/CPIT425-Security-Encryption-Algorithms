/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author areej
 */
import java.util.*;
import javax.crypto.*;
import java.io.*;
import java.security.*;

public class RSA {

    public static void main(String[] args) throws Exception {

        String str = "Java programming language support the RSA and DES algorithms.";
        System.out.println("The plain text: " + str + "\n");
        // --------- DES ---------
        //convert string to byte array 
        byte[] utf8 = str.getBytes();

        KeyGenerator kg = KeyGenerator.getInstance("DES");
        Key key = kg.generateKey();

        //Create the Cipher object with DES algorithm
        Cipher c = Cipher.getInstance("DES");

        //initialize the cipherobject, set mode to encrypt and pass the key.
        c.init(Cipher.ENCRYPT_MODE, key);

        //encrypt the message using doFinal
        byte[] myEncryptedBytes = c.doFinal(utf8);

        // to convert the byte array to a readable string use the encoding scheme "base64"
        //Ex. String encryptedText =Base64.getEncoder().encodeToString(myEncryptedBytes);
        String encryptedText = Base64.getEncoder().encodeToString(myEncryptedBytes);

        //to decrypt initialize the same cipher object, set mode to decrypt and pass the key.
        c.init(Cipher.DECRYPT_MODE, key);

        // decrypt using doFinal
        byte[] myDecryptedBytes = c.doFinal(myEncryptedBytes);

        // convert byte array to string for printing 
        String decrypteddata = new String(myDecryptedBytes);

        System.out.println("The Encryption using DES Algorithem : " + encryptedText);
        System.out.println("The Decryption using DES Algorithem : " + decrypteddata + "\n");

        // --------- RSA ---------
        // Generate keys
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        KeyPair myPair = generator.generateKeyPair();

        c = Cipher.getInstance("RSA");
        
        c.init(Cipher.ENCRYPT_MODE, myPair.getPublic());
        myEncryptedBytes = c.doFinal(utf8);
        encryptedText = Base64.getEncoder().encodeToString(myEncryptedBytes);

        c.init(Cipher.DECRYPT_MODE, myPair.getPrivate());
        myDecryptedBytes = c.doFinal(myEncryptedBytes);
        decrypteddata = new String(myDecryptedBytes);

        System.out.println("The Encryption using RSA Algorithem : " + encryptedText);
        System.out.println("The Decryption using RSA Algorithem : " + decrypteddata);

    }

}
