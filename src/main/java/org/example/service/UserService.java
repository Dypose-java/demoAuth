package org.example.service;

import org.example.domain.User;
import org.example.exception.AunteficationException;

public interface UserService {
   public User authentication(String userName, String password) throws AunteficationException;
}

