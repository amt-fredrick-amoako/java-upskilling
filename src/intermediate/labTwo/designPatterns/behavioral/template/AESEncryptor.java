package intermediate.labTwo.designPatterns.behavioral.template;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESEncryptor extends DataEncryptor {
    private SecretKey secretKey;

    @Override
    protected String generateKey() {
        if (secretKey == null) {
            try {
                KeyGenerator keyGen = KeyGenerator.getInstance("AES");
                keyGen.init(256); // 256-bit AES
                secretKey = keyGen.generateKey();
            } catch (Exception e) {
                throw new RuntimeException("Error while generating AES key", e);
            }
        }
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }

    @Override
    protected String encrypt(String data, String key) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(Base64.getDecoder().decode(key), "AES"));
            byte[] encrypted = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            throw new RuntimeException("Error while encrypting with AES", e);
        }
    }

    @Override
    protected String decrypt(String encryptedData, String key) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(Base64.getDecoder().decode(key), "AES"));
            byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
            return new String(decrypted);
        } catch (Exception e) {
            throw new RuntimeException("Error while decrypting with AES", e);
        }
    }
}
