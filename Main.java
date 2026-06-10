import java.util.Scanner;

class Main {

    public static String[] getInput() {

        String[] inputs = new String[2];

        Scanner scnr = new Scanner(System.in);

        System.out.print("Please input encryption key: ");
        String encryptionKey = scnr.nextLine();

        System.out.print("Please input string to encrypt: ");
        String plaintextString = scnr.nextLine();

        scnr.close();

        inputs[0] = encryptionKey;
        inputs[1] = plaintextString;

        return inputs;

    }

    public static void main(String[] args) {

        String[] inputs = getInput();

        String encryptionKey = inputs[0];
        String plaintextString = inputs[1];

        Encryptor crypt = new Encryptor(encryptionKey);

        String encryptedString = crypt.encrypt(plaintextString);
        String decryptedString = crypt.decrypt(encryptedString);

        System.out.printf(
                "\n\nEncryption String: %s\nPlaintext String: %s\nEncrypted String: %s\nDecrypted String: %s\n\n",
                encryptionKey, plaintextString,
                encryptedString, decryptedString);

    }

}