package org.example.io;

import org.example.domain.User;

public interface MainView extends  View {

    void showError(Throwable throwable);

    void showMainFrame(User user);

    void startMessage(User user);
}
