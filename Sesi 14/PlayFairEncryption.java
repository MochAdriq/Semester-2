public class PlayfairEncryption {
    public static char[][] generatePlayfairMatrix(String key) {
        key = key.replace("J", "I").toUpperCase();
        String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
        String keyWithAlphabet = key + alphabet;
        keyWithAlphabet = keyWithAlphabet.chars().distinct().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        char[][] matrix = new char[5][5];
        int row = 0, col = 0;
        for (char ch : keyWithAlphabet.toCharArray()) {
            matrix[row][col] = ch;
            col++;
            if (col == 5) {
                row++;
                col = 0;
            }
        }
        return matrix;
    }

    public static String[] getPlayfairBigrams(String text) {
        text = text.replace("J", "I").toUpperCase();
        StringBuilder processedText = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            if (i == text.length() - 1 || text.charAt(i) == text.charAt(i + 1)) {
                processedText.append(text.charAt(i)).append("X");
                i++;
            } else {
                processedText.append(text.substring(i, i + 2));
                i += 2;
            }
        }
        int bigramsCount = (int) Math.ceil(processedText.length() / 2.0);
        String[] bigrams = new String[bigramsCount];
        for (int j = 0; j < bigramsCount; j++) {
            bigrams[j] = processedText.substring(j * 2, Math.min(j * 2 + 2, processedText.length()));
        }
        return bigrams;
    }

    public static String playfairEncrypt(String plainText, String key) {
        char[][] matrix = generatePlayfairMatrix(key);
        String[] bigrams = getPlayfairBigrams(plainText);
        StringBuilder encryptedText = new StringBuilder();
        for (String bigram : bigrams) {
            char ch1 = bigram.charAt(0);
            char ch2 = bigram.charAt(1);
            int row1 = -1, col1 = -1, row2 = -1, col2 = -1;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (matrix[i][j] == ch1) {
                        row1 = i;
                        col1 = j;
                    } else if (matrix[i][j] == ch2) {
                        row2 = i;
                        col2 = j;
                    }
                }
            }
            if (row1 == row2) {
                encryptedText.append(matrix[row1][(col1 + 1) % 5]);
                encryptedText.append(matrix[row2][(col2 + 1) % 5]);
            } else if (col1 == col2) {
                encryptedText.append(matrix[(row1 + 1) % 5][col1]);
                encryptedText.append(matrix[(row2 + 1) % 5][col2]);
            } else {
                encryptedText.append(matrix[row1][col2]);
                encryptedText.append(matrix[row2][col1]);
            }
        }
        return encryptedText.toString();
    }

    public static void main(String[] args) {
        String plainText = "HELLO";
        String key = "KEYWORD";
        String encryptedText = playfairEncrypt(plainText, key);

        System.out.println("Plain text: " + plainText);
        System.out.println("Key: " + key);
        System.out.println("Encrypted text: " + encryptedText);
    }
}
       
