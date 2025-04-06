package authentication.io;


import authentication.domain.User;
import authentication.exceptions.AunteficationException;


public interface LoginView extends Views {
    User doLogin() throws AunteficationException;
}

