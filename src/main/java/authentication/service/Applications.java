package authentication.service;

import authentication.domain.User;
import authentication.exceptions.AunteficationException;
import authentication.io.ActionsViews;
import authentication.io.LoginView;

public class Applications {
    private final LoginView loginConsole;
    private final ActionsViews actionsViews;

    public Applications(LoginView loginConsole, ActionsViews actionsViews) {
        this.loginConsole = loginConsole;
        this.actionsViews = actionsViews;
    }

    public void run(){
        try {
            User user = loginConsole.doLogin();
        } catch (AunteficationException e) {
            actionsViews.showError(e);
            actionsViews.showAttempts();
            run();
        }

    }
}
