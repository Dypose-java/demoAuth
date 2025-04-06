package org.example.io;

import org.example.domain.User;
import org.example.exception.AunteficationException;
import org.example.service.UserService;

import javax.swing.*;

public class SwingLoginView implements LoginView {
    private final UserService userService;

    public SwingLoginView(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User doLogin() throws AunteficationException {
        String userName=showInputPopup("Введите имя пользователя: ");
        String password=showInputPopup("Введите пароль: ");
        return userService.authentication(userName,password);
    }

    private String showInputPopup(String message){
        return (String) JOptionPane.showInputDialog(null
                ,message
                ,APP_NAME
                ,JOptionPane.QUESTION_MESSAGE
                ,FIRST_ICON
                ,null
                , null);

    }

}
