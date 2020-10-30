package mining.service.services;

import mining.service.pojo.Block;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;

@Service
public class BlockUtilService {

    public static String applySHA256(String input) {

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String calculateHash(Block block) {
        return BlockUtilService.applySHA256(
                block.getPreviousHash() +
                        block.getTimestamp() +
                        block.getNonce() +
                        block.getData()
        );
    }
}
