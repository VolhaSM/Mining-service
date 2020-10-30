package mining.service.repository;

import mining.service.pojo.BlockTransactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockTransactionRepo extends CrudRepository<BlockTransactions, String> {

    BlockTransactions findFirstByStatus(String searchStr);


}
