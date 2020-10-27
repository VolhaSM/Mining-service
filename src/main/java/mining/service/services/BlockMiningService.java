package mining.service.services;

import mining.service.pojo.Block;
import mining.service.pojo.BlockTransactions;
import mining.service.repository.BlockRepo;
import mining.service.repository.BlockTransactionRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BlockMiningService {

    private static final Logger Log = LoggerFactory.getLogger(BlockMiningService.class);

    @Autowired
    BlockRepo blockRepo;

    @Autowired
    BlockTransactionRepo blockTransactionRepo;

    public void createNewBlock(String walletId) {

        if (blockRepo.findFirstByOrderByTimestampDesc() == null) {

            Block genesisBlock = new Block();
            genesisBlock.setHash("genesis");
            genesisBlock.setData("genesis");
            genesisBlock.setWalletId(walletId);
            genesisBlock.setTimestamp(System.currentTimeMillis());
            blockRepo.save(genesisBlock);

            Log.info("Genesis block is created {}", genesisBlock);
        } else {


            Block newBlock = new Block();

            Log.info("DATA OF BLOCK IS: {}", blockTransactionRepo.findFirstByStatus("inProgress"));


            if (blockTransactionRepo.findFirstByStatus("inProgress").toString() != null) {
                newBlock.setData(blockTransactionRepo.findFirstByStatus("inProgress").toString());
            } else {
                newBlock.setData("no transaction");
            }

            newBlock.setWalletId(walletId);
            newBlock.setTimestamp(System.currentTimeMillis());
            newBlock.setPreviousHash(blockRepo.findFirstByOrderByTimestampDesc().getHash());

            newBlock.setHash(newBlock.calculateHash());

            blockRepo.save(newBlock);

            Log.info("Genesis block is created {}", newBlock);

        }
    }

        public void findTxInProgress(Block newBlock){

            String txInProgress = blockTransactionRepo.findFirstByStatus("inProgress").toString();
            if ( txInProgress!= null) {
                newBlock.setData(txInProgress);

            }
            else {
                newBlock.setData("no free transactions");
            }
        }
    }


}

