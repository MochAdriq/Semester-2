import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;

import javax.crypto.Cipher;

public class RSAEncryption {
    public static byte[] rsaEncrypt(String plainText, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return encryptedBytes;
    }

    public static String rsaDecrypt(byte[] encryptedBytes, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        String decryptedText = new String(decryptedBytes);
        return decryptedText;
    }

    public static void main(String[] args) throws Exception {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

        String plainText = "Hello, RSA encryption!";

        // Generate RSA key pair
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        // Encrypt the plain text using the public key
        byte[] encryptedBytes = rsaEncrypt(plainText, publicKey);

        // Decrypt the encrypted bytes using the private key
        String decryptedText = rsaDecrypt(encryptedBytes, privateKey);

        System.out.println("Plain text: " + plainText);
        System.out.println("Encrypted text: " + new String(encryptedBytes));
        System.out.println("Decrypted text: " + decryptedText);
    }
}
