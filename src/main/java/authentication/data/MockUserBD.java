package authentication.data;

import authentication.domain.User;
import org.example.exception.AunteficationException;
import org.example.service.SecurityService;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MockUserBD implements UserBD {

    @Override
    public List<User> listAllUsers() {
        try {
            User user = new User("login1",new SecurityService().calculateHash("52"));
            User user1 = new User("login2",new SecurityService().calculateHash("5223"));
            User user2 = new User("login3",new SecurityService().calculateHash("522312"));
            return List.of(user,user1,user2);

        } catch (NoSuchAlgorithmException e) {
            //return List.of();
            throw new RuntimeException(e);
        }
    }


}
