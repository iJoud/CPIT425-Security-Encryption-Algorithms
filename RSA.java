
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

        Scanner scan = new Scanner(System.in);
        String plaintext;
        System.out.println("Enter plaintext to encrypt using RSA: ");

        plaintext = scan.nextLine();

        // Generate keys
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        KeyPair myPair = generator.generateKeyPair();

        Cipher c = Cipher.getInstance("RSA");
        
        c.init(Cipher.ENCRYPT_MODE, myPair.getPublic());
        byte[] myEncryptedBytes = c.doFinal(plaintext.getBytes());
        String encryptedText = Base64.getEncoder().encodeToString(myEncryptedBytes);

        c.init(Cipher.DECRYPT_MODE, myPair.getPrivate());
        byte[] myDecryptedBytes = c.doFinal(myEncryptedBytes);
        String decrypteddata = new String(myDecryptedBytes);

        System.out.println("The Encryption using RSA Algorithem : " + encryptedText);
        System.out.println("The Decryption using RSA Algorithem : " + decrypteddata);

    }

}
