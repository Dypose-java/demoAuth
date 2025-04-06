package org.example.service;

import org.example.domain.User;
import org.example.exception.AunteficationException;
import org.example.io.LoginView;
import org.example.io.MainView;

public class Application {
    private final LoginView loginView;
    private final MainView mainView;

    public Application(LoginView loginView, MainView mainView) {
        this.loginView = loginView;
        this.mainView = mainView;
    }

    public void run(){
        try {
            User user =loginView.doLogin();
            mainView.showMainFrame(user);
            mainView.startMessage(user);
        } catch (AunteficationException e) {
            mainView.showError(e);
          //run();//рекурсия для повторной регистрации для выхода в jFrame кнопка для выхорда
        }
    }
}
