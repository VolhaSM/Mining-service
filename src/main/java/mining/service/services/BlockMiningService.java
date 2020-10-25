package mining.service.services;

import mining.service.pojo.Block;
import mining.service.repository.BlockRepo;
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

    public void createNewBlock(String walletId) {

        if (blockRepo.findFirstByOrderByTimestampDesc() == null) {

//        ArrayList<Block> blocks = (ArrayList<Block>) blockRepo.findAll();
//
//        Log.info("Find all results{}", blocks == null);

            Block genesisBlock = new Block();
            genesisBlock.setHash("genesis");
            genesisBlock.setData("genesis");
            genesisBlock.setWalletId(walletId);
            genesisBlock.setTimestamp(System.currentTimeMillis());
            blockRepo.save(genesisBlock);

            Log.info("Genesis block is created {}", genesisBlock);
        } else {
            Block newBlock = new Block();
            newBlock.setHash("new block");
            newBlock.setData("new block");
            newBlock.setWalletId(walletId);
            newBlock.setTimestamp(System.currentTimeMillis());
            newBlock.setPreviousHash(blockRepo.findFirstByOrderByTimestampDesc().getHash());

            blockRepo.save(newBlock);

            Log.info("Genesis block is created {}", newBlock);

        }
    }
}

//    public static ArrayList<Block> blockchain = new ArrayList<Block>();
//    public static int difficulty = 2;
//    public boolean startMining(Wallet wallet) {
//
//
//        blockchain.add(new Block("1 block", "0"));
//        System.out.println("Trying to mine block 1...");
//        blockchain.get(0).mineBloc(difficulty);
//
//
//
//
//
//        return true;
//
//    }
//
//    public void createNewBlock() {
//
//
//        Block block = new Block();
//        block.setTimestamp(new Date().getTime());
//
//        blockRepo.save(block);
//
//
//    }

