package org.example.data;

import org.example.domain.User;
import org.example.service.SecurityService;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

public class MockUserRepository implements UserRepository {
    @Override
    public Optional<User> findUserByUserName(String userName) {
        final String pas="12345";

        try {
            User user = new User("Dypose",52,new SecurityService().calculateHash(pas));
            User user1 = new User("Integga",1337,new SecurityService().calculateHash(pas));
            user.addUsersToContactList(user1);
            if (userName.equals("Dypose"))
            return Optional.of(user);
            else
                return Optional.empty();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<User> findUserByIdSessions(String userName) {
        return Optional.empty();
    }
}
