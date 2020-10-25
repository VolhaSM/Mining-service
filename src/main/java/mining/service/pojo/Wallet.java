package mining.service.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.security.*;
import java.security.spec.ECGenParameterSpec;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Wallet {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    private String userId;
    private String publicKey;
    private String privateKey;

//    public Wallet() {
//        generateKeyPair();
//    }
//
//    public void generateKeyPair() {
//        try {
//            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA","BC");
//            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
//            ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
//            // Initialize the key generator and generate a KeyPair
//            keyGen.initialize(ecSpec, random);   //256 bytes provides an acceptable security level
//            KeyPair keyPair = keyGen.generateKeyPair();
//            // Set the public and private keys from the keyPair
//            privateKey = keyPair.getPrivate();
//            publicKey = keyPair.getPublic();
//        }catch(Exception e) {
//            throw new RuntimeException(e);
//        }
  //  }

}
