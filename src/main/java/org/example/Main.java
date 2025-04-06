package org.example;

import org.example.data.MockMessageRepository;
import org.example.data.MockUserRepository;
import org.example.io.SwingLoginView;
import org.example.io.SwingMainView;
import org.example.service.Application;
import org.example.service.MainUserService;
import org.example.service.SecurityService;

public class Main {
    public static void main(String[] args) {
        new Application(
                new SwingLoginView(
                        new MainUserService(
                                new SecurityService(),
                                new MockUserRepository())),
                new SwingMainView(
                        new MockMessageRepository())).run();
    }
}