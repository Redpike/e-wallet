package com.e_wallet.repository.user;

import com.e_wallet.entity.user.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService
//        extends JpaRepository<User, Integer>
{

    Optional<User> findUserByUsername(String username);
}
