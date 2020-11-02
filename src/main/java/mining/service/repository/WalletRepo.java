package mining.service.repository;

import mining.service.pojo.Wallet;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WalletRepo extends CrudRepository <Wallet, String> {
    Optional<Wallet> findById (String walletId);
}
