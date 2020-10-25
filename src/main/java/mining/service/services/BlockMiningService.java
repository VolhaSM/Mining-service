package mining.service.services;

import mining.service.pojo.Block;
import mining.service.repository.BlockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BlockMiningService {

    @Autowired
    BlockRepo blockRepo;

    public void createNewBlock(String walletId) {

        if(blockRepo.findAll() == null) {
            Block genesisBlock = new Block(null, null);
            blockRepo.save(genesisBlock);
        }

        else{
            Block newBlock = new Block(null, null);
            newBlock.setPreviousHash(blockRepo.findFirstByOrderByTimestampDesc().getHash());

            blockRepo.save(newBlock);

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
}
