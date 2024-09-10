package intermediate.labTwo.designPatterns.behavioral.template;

public class CaesarCipherEncryptor extends DataEncryptor {
    @Override
    protected String generateKey() {
        // For simplicity, the key is a fixed integer shift
        return "3"; // A shift of 3 for Caesar Cipher
    }

    @Override
    protected String encrypt(String data, String key) {
        int shift = Integer.parseInt(key);
        StringBuilder encrypted = new StringBuilder();
        for (char c : data.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                encrypted.append((char) ((c - base + shift) % 26 + base));
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }

    @Override
    protected String decrypt(String encryptedData, String key) {
        int shift = Integer.parseInt(key);
        StringBuilder decrypted = new StringBuilder();
        for (char c : encryptedData.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                decrypted.append((char) ((c - base - shift + 26) % 26 + base));
            } else {
                decrypted.append(c);
            }
        }
        return decrypted.toString();
    }
}
