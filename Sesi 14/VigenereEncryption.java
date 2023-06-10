public class VigenereEncryption {
    public static String vigenereEncrypt(String plainText, String key) {
        StringBuilder encryptedText = new StringBuilder();
        plainText = plainText.toUpperCase();
        key = key.toUpperCase();
        int plainTextLength = plainText.length();
        int keyLength = key.length();
        for (int i = 0; i < plainTextLength; i++) {
            char plainChar = plainText.charAt(i);
            char keyChar = key.charAt(i % keyLength);
            if (Character.isLetter(plainChar)) {
                char encryptedChar = (char) (((plainChar - 'A') + (keyChar - 'A')) % 26 + 'A');
                encryptedText.append(encryptedChar);
            } else {
                encryptedText.append(plainChar);
            }
        }
        return encryptedText.toString();
    }

    public static void main(String[] args) {
        String plainText = "HELLO";
        String key = "KEY";
        String encryptedText = vigenereEncrypt(plainText, key);
        System.out.println(encryptedText);  // Output: RIJVS
    }
}
