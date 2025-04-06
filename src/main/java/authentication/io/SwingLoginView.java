package authentication.io;

import authentication.data.MockUserBD;
import authentication.domain.User;
import authentication.exceptions.AunteficationException;
import authentication.service.MainUserService;
import authentication.service.SecurityService;
import authentication.service.Userservice;



import javax.swing.*;

import static javax.swing.JOptionPane.QUESTION_MESSAGE;

public class SwingLoginView implements LoginView {
    private  final Userservice userService;

    public SwingLoginView(Userservice userService) {
        this.userService = userService;
    }


    @Override
    public User doLogin() throws AunteficationException {
       String login=showInputDialog("Введите логин");
       if (login.isEmpty()){
           throw  new AunteficationException("Логин не может быть пустым");
       }
       String pas=showInputDialog("Введите пароль");

       if (pas.isEmpty()){
           throw new AunteficationException("Пароль не может быть пустым");
       }
       return userService.authentication(login,pas);
    }
    private String showInputDialog(String message){
        return (String) JOptionPane.showInputDialog(null,
                message,
                NAME_APP,
                QUESTION_MESSAGE,
                FIRST_ICON,
                null,
                null);
    }


    public static void main(String[] args) throws AunteficationException {
        new SwingLoginView(new MainUserService(new MockUserBD(),new SecurityService())).doLogin();
    }
}
