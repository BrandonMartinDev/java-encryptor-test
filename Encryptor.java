public class Encryptor {

    // Variables

    private String encryptionKey;
    private char[][] vigenereTable;

    // Constructors

    public Encryptor(String key) {

        key = key.toUpperCase().trim();

        if (!validateEncryptionKey(key)) {
            System.err.println("ERROR | 'key' must contain only letters");
            return;
        }

        this.encryptionKey = key;
        this.vigenereTable = createVigenereTable();

    }

    // Getters/Setters

    // Private Methods

    private boolean validateEncryptionKey(String key) {

        for (int i = 0; i < key.length(); i++) {

            char character = key.charAt(i);

            if (!Character.isLetter(character)) {
                return false;
            }

        }

        return true;

    }

    private void printVigenereTable() {

        for (int rowNum = 0; rowNum < vigenereTable.length; rowNum++) {

            char[] row = vigenereTable[rowNum];
            char rowLetter = (char) (rowNum + 65);

            System.out.printf("%s: ", rowLetter);

            for (int letterNum = 0; letterNum < row.length; letterNum++) {
                char letter = row[letterNum];
                System.out.print(letter);

            }

            System.out.println();

        }

    }

    private char[][] createVigenereTable() {

        char[][] vigenereTable = new char[26][26];

        for (int rowNum = 0; rowNum < vigenereTable.length; rowNum++) {

            char[] row = new char[26];

            char rowLetter = (char) ('A' + rowNum);
            rowLetter = (rowLetter > 90) ? (char) (rowLetter - 65) : rowLetter;

            for (int letterNum = 0; letterNum < 26; letterNum++) {

                char colLetter = (char) (rowLetter + letterNum);
                colLetter = (colLetter > 90) ? (char) (colLetter - 26) : colLetter;

                row[letterNum] = colLetter;

            }

            vigenereTable[rowNum] = row;

        }

        return vigenereTable;

    }

    // Public Methods

    public char encryptCharacter(char plaintextCharacter, char encryptionCharacter) {

        int rowNum = (plaintextCharacter - 65);
        int colNum = (encryptionCharacter - 65);

        if (rowNum < 0 || rowNum > 26 || colNum < 0 || colNum > 26) {
            return plaintextCharacter;
        }

        return this.vigenereTable[rowNum][colNum];

    }

    public char decryptCharacter(char encryptedCharacter, char encryptionCharacter) {

        int encryptionCharNum = (encryptionCharacter - 65);

        if (encryptionCharNum < 0 || encryptionCharNum > 26) {
            return encryptedCharacter;
        }

        char[] row = this.vigenereTable[encryptionCharNum];

        for (int i = 0; i < row.length; i++) {

            if (row[i] == encryptedCharacter) {
                return this.vigenereTable[0][i];
            }

        }

        return encryptedCharacter;

    }

    public String encrypt(String plaintextString) {

        String encryptedString = "";

        for (int i = 0; i < plaintextString.length(); i++) {

            char plaintextCharacter = Character.toUpperCase(plaintextString.charAt(i));
            char encryptionCharacter = encryptionKey.charAt(i % this.encryptionKey.length());

            char encryptedCharacter = encryptCharacter(plaintextCharacter, encryptionCharacter);

            encryptedString += encryptedCharacter;

        }

        return encryptedString;

    }

    public String decrypt(String encryptedString) {

        String plaintextString = "";

        for (int i = 0; i < encryptedString.length(); i++) {

            char encryptedCharacter = Character.toUpperCase(encryptedString.charAt(i));
            char encryptionCharacter = encryptionKey.charAt(i % this.encryptionKey.length());

            char plaintextCharacter = decryptCharacter(encryptedCharacter, encryptionCharacter);

            plaintextString += plaintextCharacter;

        }

        return plaintextString;

    }

}
