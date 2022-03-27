
import java.security.*;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class MD {

    public static void main(String args[]) throws Exception {

        MessageDigest sh = MessageDigest.getInstance("SHA-1");
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        int i = 0;

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Message1: ");
        String str = scan.nextLine();
        System.out.print("Enter Message2: ");
        String str2 = scan.nextLine();

        byte[] data1 = str.getBytes("UTF8");
        sh.update(data1);
        byte[] msgDigest_sh = sh.digest();
        sh.reset();
        byte[] data2 = str2.getBytes("UTF8");
        sh.update(data2);
        byte[] msgDigest_sh2 = sh.digest();
        sh.reset();

        // Using SHA-1
        System.out.println("--- The First Message Digest Using SHA-1---");

        String hex_str = new BigInteger(1, msgDigest_sh).toString(16).toUpperCase();
        System.out.println(hex_str);

        for (byte b : msgDigest_sh) {
            System.out.print(b + " ");
            i++;
        }

        System.out.println("\nThe output size is  : " + i + "   ");
        System.out.print("\n");

        System.out.println("--- The Second Message Digest Using SHA-1---");

        String hex_str2 = new BigInteger(1, msgDigest_sh2).toString(16).toUpperCase();
        System.out.println(hex_str2);
        i = 0;
        for (byte b : msgDigest_sh2) {
            System.out.print(b + " ");
            i++;
        }

        System.out.println("\nThe output size is  : " + i + "   ");
        System.out.print("\n");

    }
}

