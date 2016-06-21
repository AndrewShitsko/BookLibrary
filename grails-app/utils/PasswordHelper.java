import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class PasswordHelper {

    public static class SaltHash {
        private String hash;
        private String salt;

        public SaltHash(String hash, String salt) {
            this.hash = hash;
            this.salt = salt;
        }

        public String getHash() {
            return this.hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }

        public String getSalt() {
            return this.salt;
        }

        public void setSalt(String salt) {
            this.salt = salt;
        }
    }

    public static SaltHash computeHashWithSalt(String value) {
        String salt = generateSalt();
        String hash = computeHashWithSalt(value, salt);
        return new SaltHash(hash, salt);
    }

    public static boolean verifyHash(String value, String hash, String salt) {
        String tempHash = computeHashWithSalt(value, salt);
        return tempHash.equals(hash);
    }

    private static String computeHashWithSalt(String value, String salt) {
        return computeHash(value + salt);
    }

    private static String computeHash(String value) {
        String hash = null;

        try {
            hash = Hex.encodeHexString(MessageDigest.getInstance("SHA-256").digest(value.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return hash;
    }

    private static String generateSalt() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
