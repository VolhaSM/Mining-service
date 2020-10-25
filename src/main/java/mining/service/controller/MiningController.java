package mining.service.controller;

import mining.service.pojo.Wallet;
import mining.service.services.BlockMiningService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MiningController {
    BlockMiningService blockMiningService;

    @PostMapping(value = "/start-mining")
    public ResponseEntity startMining(@RequestBody Wallet wallet) {

        return null;
//        if(blockMiningService.startMining(wallet)) {
//            return new ResponseEntity(HttpStatus.OK);
//        }
//        else{
//            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
//        }

    }
}
