package intermediate.labTwo.designPatterns.behavioral.template;

public abstract class DataEncryptor {

    // Template method
    public final String encryptData(String data) {
        String key = generateKey();
        String encryptedData = encrypt(data, key);
        System.out.println("Encrypted data: " + encryptedData);
        return encryptedData;
    }

    public final String decryptData(String encryptedData) {
        String key = generateKey();
        String decryptedData = decrypt(encryptedData, key);
        System.out.println("Decrypted data: " + decryptedData);
        return decryptedData;
    }

    // Methods to be implemented by subclasses
    protected abstract String generateKey();
    protected abstract String encrypt(String data, String key);
    protected abstract String decrypt(String encryptedData, String key);
}
