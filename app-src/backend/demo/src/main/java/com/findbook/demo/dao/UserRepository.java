package com.findbook.demo.dao;

import com.findbook.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Override
    public List<User> findAll();


    /*    User findOneByUsername(String username);*/

    User findByEmail(String email);

    User findByUsername(String user);

    //Enable user
    @Transactional
    @Modifying
    @Query("UPDATE User a " +
            "SET a.enable = TRUE WHERE a.email = ?1")
    int enableUser(String email);


/*    @Query(value = "SELECT EXPIRES_AT FROM CONFIRMATION_TOKEN t JOIN USERS u ON t.USER_ID = u.USER_ID WHERE u.USER_ID=?1", nativeQuery = true)
    LocalDateTime checkIsExpired(long id);*/
}
