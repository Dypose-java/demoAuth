package org.example.service;

import org.example.data.UserRepository;
import org.example.domain.User;
import org.example.exception.AunteficationException;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Optional;

public class MainUserService implements UserService {
    private final SecurityService service;
    private final UserRepository userRepository;

    public MainUserService(SecurityService service, UserRepository userRepository) {
        this.service = service;
        this.userRepository = userRepository;
    }

    @Override
    public User authentication(String userName, String password) throws AunteficationException {
        Optional<User> userByUserName = userRepository.findUserByUserName(userName);
        if (userByUserName.isPresent()){
            User user = userByUserName.get();
            try {
                byte[] givenHash = service.calculateHash(password);
                if (Arrays.equals(givenHash,user.getPasswordHash()))
                    return user;
                else
                    throw new AunteficationException("неверный пароль");

            } catch (NoSuchAlgorithmException e) {
                throw new AunteficationException("Ошибка подсчета хеша",e);
            }
        }else {
            throw new AunteficationException("Не найден пользователь по имени: "+userName);
        }
    }
}
