package authentication.io;

import authentication.domain.User;
import authentication.exceptions.AunteficationException;
import authentication.service.Userservice;


import java.util.Scanner;

public class IoLoginConsole implements LoginView {
    private final Userservice userservice;
    private Scanner scanner = new Scanner(System.in);

    public IoLoginConsole(Userservice userservice) {
        this.userservice = userservice;
    }



    @Override
    public User doLogin() throws AunteficationException {
        System.out.println("Введите логин");
        String login =scanner.nextLine();

        System.out.println("Введите пароль");
        String pas =scanner.nextLine();

       return userservice.authentication(login,pas);
    }
}
