package com.Dinku007.auth;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Anand SN
 */
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);

}
