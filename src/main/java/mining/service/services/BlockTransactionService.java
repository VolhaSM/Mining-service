package mining.service.services;

import mining.service.pojo.BlockTransactions;
import mining.service.repository.BlockTransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlockTransactionService {

    @Autowired
    BlockTransactionRepo blockTransactionRepo;


    public void createNewTransaction(String recipientId, double value) {

        if (blockTransactionRepo.findAll() == null) {

            BlockTransactions genesisTransaction = new BlockTransactions();
            genesisTransaction.setRecipient(recipientId);
            genesisTransaction.setValue(500.0);
            blockTransactionRepo.save(genesisTransaction);

        }


    }
}
