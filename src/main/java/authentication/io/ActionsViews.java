package authentication.io;

public interface ActionsViews extends Views {
    void showError(Throwable throwable);
    void showAttempts();
}

