package com.ffivrpportal.repository;

import com.ffivrpportal.model.Role;
import com.ffivrpportal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    List<User> findAllByRolesIn(Set<Role> roleSet);

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE User u SET u.email = ?1 WHERE u.id = ?2")
    void updateUsername(String email, Long id);


    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE User u SET u.password = ?1 WHERE u.id = ?2")
    void updatePassword(String password, Long id);

}
