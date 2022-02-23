
import java.util.*;
import javax.crypto.*;
import java.io.*;
import java.security.*;

public class DES {

    public static void main(String[] args) throws Exception{

        System.out.print("Enter Your Message : " );
        Scanner scan = new Scanner(System.in);
        String message = scan.nextLine();
        byte[] ByteMessage = message.getBytes();
        KeyGenerator kg = KeyGenerator.getInstance("DES");
        Key key = kg.generateKey();
        Cipher c = Cipher.getInstance("DES");
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] myEncryptedBytes = c.doFinal(ByteMessage);
        String encryptedText = Base64.getEncoder().encodeToString(myEncryptedBytes);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] myDecryptedBytes = c.doFinal(myEncryptedBytes);
        String decrypteddata = new String(myDecryptedBytes);
        
        System.out.println("Encrypted - " + encryptedText);
        System.out.println("Decrypted Message - " + decrypteddata);
        
    }
}
