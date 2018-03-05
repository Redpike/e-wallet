package com.e_wallet.controllers.saving;

import com.e_wallet.entity.role.Role;
import com.e_wallet.util.RestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping(RestUtil.SAVING_API)
public class SavingRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SavingRestController.class);

    private static List<Role> roleList;
    private static int maxId = 0;

    /**
     * For testing
     */
    static {
        roleList = new ArrayList<>();
        roleList.add(createTempRole(1, "Admin of system"));
        roleList.add(createTempRole(2, "Admin of group"));
        roleList.add(createTempRole(3, "User"));
        roleList.add(createTempRole(3, "Moderator"));
    }

    private static Role createTempRole(Integer id, String roleName) {
        Role role = new Role();
        role.setId(id);
        role.setName(roleName);

        return role;
    }

    private static Integer getNextId() {
        roleList.stream().map(Role::getId).forEach(roleId -> {
            if (maxId < roleId)
                maxId = roleId;
        });

        return maxId + 1;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Role>> getAllRoles() {
        LOGGER.info("Getting list of all roles.");
        if (roleList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(roleList, HttpStatus.OK);
    }

    @RequestMapping(path = "/{rolename}", method = RequestMethod.GET)
    public ResponseEntity<Role> getRoleByName(@PathVariable("rolename") String rolename) {
        LOGGER.info("Getting role by rolename.");
        for (Role role : roleList)
            if (role.getName().equalsIgnoreCase(rolename))
                return new ResponseEntity<>(role, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> createRole(@RequestBody Role role) {
        LOGGER.info("Adding new role.");
        if (!roleList.contains(role)) {
            role.setId(getNextId());
            roleList.add(role);
            return new ResponseEntity<>("Role " + role + " added to database.", HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Role> updateRole(@RequestBody Role editedRole) {
        LOGGER.info("Editing role.");
        for (Role role : roleList)
            if (role.getId().equals(editedRole.getId())) {
                Collections.replaceAll(roleList, role, editedRole);
                return new ResponseEntity<>(editedRole, HttpStatus.OK);
            }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(path = "/{rolename}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteRole(@PathVariable("rolename") String rolename) {
        LOGGER.info("Deleting role.");
        for (Role role : roleList)
            if (role.getName().equalsIgnoreCase(rolename)) {
                roleList.remove(role);
                return new ResponseEntity<>("Role deleted", HttpStatus.OK);
            }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
