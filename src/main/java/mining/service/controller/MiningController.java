package mining.service.controller;

import mining.service.pojo.Wallet;
import mining.service.services.BlockMiningService;
import mining.service.services.BlockTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController


public class MiningController {
    @Autowired
    BlockMiningService blockMiningService;

    @Autowired
    BlockTransactionService blockTransactionService;

    @RequestMapping("/{walletId}/start-mining.html")
    public String startMining(
            @PathVariable String walletId
    ) {

        blockMiningService.createNewBlock("new block");
//        blockTransactionService.createNewTransaction(recipientId, walletId, value);

        return "ok";
//        if(blockMiningService.startMining(wallet)) {
//            return new ResponseEntity(HttpStatus.OK);
//        }
//        else{
//            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
//        }

    }
}
