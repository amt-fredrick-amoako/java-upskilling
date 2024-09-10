package intermediate.labTwo.designPatterns.behavioral.template;

public class Program {
    public static void main(String[] args) {
        DataEncryptor caesarEncryptor = new CaesarCipherEncryptor();
        String encryptedCaesar = caesarEncryptor.encryptData("Hello World!");
        System.out.println("Encrypted with Caesar Cipher: " + encryptedCaesar);
        String decryptedCaesar = caesarEncryptor.decryptData(encryptedCaesar);
        System.out.println("Decrypted with Caesar Cipher: " + decryptedCaesar);

        DataEncryptor aesEncryptor = new AESEncryptor();
        String encryptedAES = aesEncryptor.encryptData("Hello World!");
        System.out.println("Encrypted with AES: " + encryptedAES);
        String decryptedAES = aesEncryptor.decryptData(encryptedAES);
        System.out.println("Decrypted with AES: " + decryptedAES);
    }
}
