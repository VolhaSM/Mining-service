package mining.service.services;

import mining.service.pojo.BlockTransactions;
import mining.service.repository.BlockTransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlockTransactionService {

    @Autowired
    BlockTransactionRepo blockTransactionRepo;


    public void createNewTransaction(String recipientId, String walletId, double value) {

        if (blockTransactionRepo.findAll() == null) {

            BlockTransactions genesisTransaction = new BlockTransactions(null, walletId, 50);
            blockTransactionRepo.save(genesisTransaction);

        } else {

            BlockTransactions transaction = new BlockTransactions(recipientId, walletId, value);
            blockTransactionRepo.save(transaction);

        }


    }
}
