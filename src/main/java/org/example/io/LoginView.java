package org.example.io;

import org.example.domain.User;
import org.example.exception.AunteficationException;

public interface LoginView extends View {
    User doLogin() throws AunteficationException;
}

