public class EncryptorTest {

    public static boolean runTest(String encryptionKey, String plaintextString) {

        encryptionKey = encryptionKey.toUpperCase();
        plaintextString = plaintextString.toUpperCase();

        Encryptor crypt = new Encryptor(encryptionKey);

        String encryptedString = crypt.encrypt(plaintextString);
        String decryptedString = crypt.decrypt(encryptedString);

        return plaintextString.equals(decryptedString);

    }

    public static void main(String[] args) {

        System.out.println(runTest("cover", "thankyou"));
        System.out.println(runTest("kryptos", "this is a test of encryption"));

    }

}
