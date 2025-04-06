package authentication.service;

import authentication.data.MockUserBD;
import authentication.data.UserBD;
import authentication.domain.User;
import authentication.exceptions.AunteficationException;


import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MainUserService implements Userservice {
    private final UserBD userBD;
    private final SecurityService service;

    public MainUserService(UserBD userBD, SecurityService service) {
        this.userBD = userBD;
        this.service = service;
    }

    @Override
    public User authentication(String login, String pas) throws AunteficationException {
        List<User> list = userBD.listAllUsers();
        Optional<User> first = list.stream().filter(user -> user.getLogin().equals(login)).findFirst();
        if (first.isPresent()){
            User user =first.get();
            try {
                if (Arrays.equals(service.calculateHash(pas),user.getPassword()))
                    return user;
                else {
                    System.out.println("неверный пароль");
                    throw new AunteficationException("неверный пароль");
                }
            } catch (NoSuchAlgorithmException e) {
                System.out.println("ошибка хеш");
                throw new AunteficationException("ошибка хеш",e);
            }
        }
        else{
            System.out.println("неверный логин");
            throw new AunteficationException("неверный логин");
        }
    }
}
