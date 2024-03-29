package com.kbtg.apidesign01.wallet;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Wallet w SET w.active =true")
    void setAllWalletsActive();

    @Modifying
    @Transactional
    @Query("DELETE Wallet w WHERE w.id < 3")
    void deleteWalletsByIdBelow3();
}
