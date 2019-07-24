package com.neuedu.project.service;

import com.neuedu.project.domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    /**
     * change user's name.
     *
     * @throws DataAccessException throws when accessing database fails
     */
//    void changeName(String userId, String newName) throws DataAccessException;

    /**
     * change a user's name.
     *
     * @param forChangingName store new name and the target
     *                        user's id to this object.
     *                        this param make no sense in reality,
     *                        so it's only for changing name.
     */
    void changeName(User forChangingName);

    /**
     * change user's password.
     *
     * @throws DataAccessException throws when accessing database fails
     */
    boolean changePassword(User user, String newPassword)
            throws DataAccessException;


    /**
     * register for a new user.
     *
     * @param userId   user id
     * @param password password
     * @param name     name
     * @param identity identity: 0-student, 1-teacher, 2-admin
     * @throws DataAccessException throws when adding user fails
     */
    void register(String userId, String password, String name, int identity)
            throws DataAccessException;

    /**
     * login for a user if the username and password are matched.
     * then add to session to mark logged in.
     *
     * @param userId   user id
     * @param password password
     * @return true iff login successfully
     */
    boolean login(String userId, String password) throws DataAccessException;

}
