package authentication;

import authentication.data.MockUserBD;
import authentication.io.MainActionsViews;
import authentication.io.SwingLoginView;
import authentication.service.Applications;
import authentication.service.MainUserService;
import authentication.service.SecurityService;

public class Main {
    public static void main(String[] args) {
        new Applications(
                new SwingLoginView(
                        new MainUserService(
                                new MockUserBD(),new SecurityService())),
                new MainActionsViews()).run();
    }
}
