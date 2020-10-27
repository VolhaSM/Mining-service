package mining.service.repository;

import mining.service.pojo.Block;
import mining.service.pojo.BlockTransactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BlockRepo extends CrudRepository <Block, String> {



    Block findFirstByOrderByTimestampDesc();



}
