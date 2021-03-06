package com.findbook.demo.dao;

import com.findbook.demo.entities.ConfirmationToken;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, Long> {

    //Queries must be here

    Optional<ConfirmationToken> findByToken(String token);

    @Transactional
    @Modifying
    @Query("UPDATE ConfirmationToken c " +
            "SET c.confirmAt = ?2 " +
            "WHERE c.token = ?1")
    int updateConfirmedAt(String token,
                          LocalDateTime confirmedAt);

/*    //Find if token is enable
    @Query(value = "SELECT count(*) FROM CONFIRMATION_TOKEN  WHERE USER_ID  =?1 AND CONFIRM_AT IS NULL", nativeQuery = true)
    int isTokenExpired(Long userId);*/
}

