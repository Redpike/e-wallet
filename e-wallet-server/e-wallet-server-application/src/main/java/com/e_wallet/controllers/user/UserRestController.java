package com.e_wallet.controllers.user;

import com.e_wallet.entity.user.User;
import com.e_wallet.util.RestUtil;
import com.e_wallet.util.enums.yes_no.YesNoEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(RestUtil.USER_API)
public class UserRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);

    private static List<User> userList;
    private static int maxId = 0;

    /**
     * For testing
     */
    static {
        userList = new ArrayList<>();
        userList.add(createTempUser(1, "rm5"));
        userList.add(createTempUser(2, "rs3"));
        userList.add(createTempUser(3, "pk1"));
        userList.add(createTempUser(4, "aa1"));
        userList.add(createTempUser(5, "bb2"));
    }

    private static User createTempUser(Integer id, String username) {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword("dasda");
        user.setSecondPassword("adsada");
        user.setFirstName("dasda");
        user.setLastName("dsadsad");
        user.setBlocked(YesNoEnum.NO);
        user.setDeleted(YesNoEnum.NO);

        return user;
    }

    private static Integer getNextId() {
        userList.stream().map(User::getId).forEach(userId -> {
            if (maxId < userId)
                maxId = userId;
        });

        return maxId + 1;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers() {
        LOGGER.info("Getting list of all users.");
        if (userList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @RequestMapping(path = "/{username}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {
        LOGGER.info("Getting user by username.");
        for (User user : userList)
            if (user.getUsername().equalsIgnoreCase(username))
                return new ResponseEntity<>(user, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> createUser(@RequestBody User user) {
        LOGGER.info("Adding new user.");
        if (!userList.contains(user)) {
            user.setId(getNextId());
            userList.add(user);
            return new ResponseEntity<>("User " + user + " added to database.", HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User editedUser) {
        LOGGER.info("Editing user.");
        for (User user : userList)
            if (user.getId().equals(editedUser.getId())) {
                Collections.replaceAll(userList, user, editedUser);
                return new ResponseEntity<>(editedUser, HttpStatus.OK);
            }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(path = "/{username}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@PathVariable("username") String username) {
        LOGGER.info("Deleting user.");
        for (User user : userList)
            if (user.getUsername().equalsIgnoreCase(username)) {
                userList.remove(user);
                return new ResponseEntity<>("User deleted", HttpStatus.OK);
            }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
