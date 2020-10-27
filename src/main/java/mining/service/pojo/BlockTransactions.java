package mining.service.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class BlockTransactions {


    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    public String id;
    public String sender;
    public String recipient;
    public double value;
    public String status;

    // Constructor:
//    public BlockTransactions(String from, String to, double value) {
//        this.sender = from;
//        this.recipient = to;
//        this.value = value;
//
//    }


    //    public byte[] signature; // this is to prevent anybody else from spending funds in our wallet.
//
//    public ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();
//    public ArrayList<TransactionOutput> outputs = new ArrayList<TransactionOutput>();

    // private static int sequence = 0; // a rough count of how many transactions have been generated.


    // This Calculates the transaction hash (which will be used as its Id)
//    private String calculateHash() {
//        sequence++; //increase the sequence to avoid 2 identical transactions having the same hash
//        return BlockUtil.applySHA256(
//                BlockUtil.getStringFromKey(sender) +
//                        BlockUtil.getStringFromKey(recipient) +
//                        Float.toString(value) + sequence
//        );
//    }

}
