package mining.service.repository;

import mining.service.pojo.Block;
import mining.service.pojo.BlockTransactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlockTransactionRepo extends CrudRepository<BlockTransactions, String> {

    List<BlockTransactions> findAll();


}
