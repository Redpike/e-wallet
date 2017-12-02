package com.e_wallet.repository.user;

import com.e_wallet.entity.user.User;

import java.util.Optional;


public interface UserRepository
//        extends JpaRepository<User, Integer>
{

    Optional<User> findUserByUsername(String username);
}
