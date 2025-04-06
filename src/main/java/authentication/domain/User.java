package authentication.domain;

import authentication.service.SecurityService;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.stream.Stream;

public class User {
    private final String login;
    private final byte[] password;

    public User(String login, byte[] password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public byte[] getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password=" + Arrays.toString(password) +
                '}';
    }

}
