package authentication.service;

import authentication.domain.User;
import authentication.exceptions.AunteficationException;


public interface Userservice {
    public User authentication(String login, String pas) throws AunteficationException;
}
