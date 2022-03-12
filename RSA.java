/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joudalghamdi
 */
import java.util.*;
import javax.crypto.*;
import java.io.*;
import java.security.*;

public class RSA {

    public static void main(String[] args) throws Exception {

        System.out.println("The plain text: " + str + "\n");

        //convert string to byte array 
        byte[] utf8 = str.getBytes();



        
        // --------- RSA ---------
        // Generate keys
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        KeyPair myPair = generator.generateKeyPair();

        Cipher c = Cipher.getInstance("RSA");
        
        c.init(Cipher.ENCRYPT_MODE, myPair.getPublic());
        byte[] myEncryptedBytes = c.doFinal(utf8);
        String encryptedText = Base64.getEncoder().encodeToString(myEncryptedBytes);

        c.init(Cipher.DECRYPT_MODE, myPair.getPrivate());
        byte[] myDecryptedBytes = c.doFinal(myEncryptedBytes);
        String decrypteddata = new String(myDecryptedBytes);

        System.out.println("The Encryption using RSA Algorithem : " + encryptedText);
        System.out.println("The Decryption using RSA Algorithem : " + decrypteddata);

    }

}
