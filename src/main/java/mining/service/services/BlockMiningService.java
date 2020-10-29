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

    @Autowired
    BlockUtilService blockUtilService;


    public Block createNewBlock(String walletId) {
        Block newBlock = new Block();

        if (blockRepo.findFirstByOrderByTimestampDesc() == null) {


            newBlock.setHash("genesis");
            newBlock.setData("genesis");
            newBlock.setWalletId(walletId);
            newBlock.setTimestamp(System.currentTimeMillis());
            blockRepo.save(newBlock);

            Log.info("Genesis block is created {}", newBlock);
        } else {


            Log.info("DATA OF BLOCK IS: {}", blockTransactionRepo.findFirstByStatus("inProgress"));

            findTxInProgress(newBlock);

            newBlock.setWalletId(walletId);
            newBlock.setTimestamp(System.currentTimeMillis());
            newBlock.setPreviousHash(blockRepo.findFirstByOrderByTimestampDesc().getHash());

            newBlock.setHash(blockUtilService.calculateHash(newBlock));


            blockRepo.save(newBlock);

            Log.info("Genesis block is created {}", newBlock);

        }
        return newBlock;

    }

    public void findTxInProgress(Block newBlock) {

        BlockTransactions txInProgress = blockTransactionRepo.findFirstByStatus("inProgress");
        if (txInProgress != null) {
            newBlock.setData(txInProgress.toString());
            txInProgress.setStatus("DONE");
            blockTransactionRepo.save(txInProgress);


        } else {
            newBlock.setData("no free transactions");
        }
    }

    public Block startMining(String walletId) {
        Block block = createNewBlock(walletId);
        mineBlock(block);

        return block;

    }


    public void mineBlock(Block block) {

        int nonce = block.getNonce();
        while (!block.getHash().startsWith("0000")) {
            nonce++;
            block.setNonce(nonce);
            block.setHash(blockUtilService.calculateHash(block));

        }

        blockRepo.save(block);


    }
}




