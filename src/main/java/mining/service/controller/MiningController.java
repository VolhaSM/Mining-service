package mining.service.controller;

import mining.service.services.BlockMiningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class MiningController {
    @Autowired
    BlockMiningService blockMiningService;


    @RequestMapping("/{walletId}/start-mining.html")
    public String startMining(
            @PathVariable String walletId
    ) {

        if (blockMiningService.startMining(walletId)) {


            return "Block is mined";
        }
        else {
            return  "Block is NOT  mined";
        }


    }
}
