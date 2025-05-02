import java.security.SecureRandom;
import java.util.Base64;

public class GenerateSecretKey {
    public static void main(String[] args) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] keyBytes = new byte[32]; // 256-bit key
        secureRandom.nextBytes(keyBytes);
        String secretKey = Base64.getEncoder().encodeToString(keyBytes);
        System.out.println("Generated Secret Key: " + secretKey);
        StringBuilder s = new StringBuilder("Java");
        System.out.print(s.reverse());
    }
}
