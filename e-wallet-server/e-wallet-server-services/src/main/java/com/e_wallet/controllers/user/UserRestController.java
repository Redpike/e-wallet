package com.e_wallet.controllers.user;

import com.e_wallet.entity.user.User;
import com.e_wallet.repository.user.UserService;
import com.e_wallet.util.RestUtil;
import com.e_wallet.util.enums.yes_no.YesNoEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(RestUtil.USER_API)
public class UserRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);

//    @Autowired
//    private UserService userService;

    private static List<User> userList;

    /**
     * For testing
     */
    static {
        User user = new User();
        user.setId(1);
        user.setUsername("dsa");
        user.setPassword("dasda");
        user.setSecondPassword("adsada");
        user.setFirstName("dasda");
        user.setLastName("dsadsad");
        user.setBlocked(YesNoEnum.NO);
        user.setDeleted(YesNoEnum.NO);
        userList = new ArrayList<>();
        userList.add(user);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> getListOfAllEntities() {
        LOGGER.info("Getting list of all users.");
        if (userList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
}
