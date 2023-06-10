public class CaesarEncryption {
    public static String caesarEncrypt(String plainText, int shift) {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                char encryptedChar = (char) (((ch - base + shift) % 26) + base);
                encryptedText.append(encryptedChar);
            } else {
                encryptedText.append(ch);
            }
        }
        return encryptedText.toString();
    }

    public static void main(String[] args) {
        String plainText = "HELLO";
        int shift = 3;
        String encryptedText = caesarEncrypt(plainText, shift);
        System.out.println(encryptedText);  // Output: KHOOR
    }
}
