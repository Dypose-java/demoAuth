package authentication.data;

import authentication.domain.User;
import org.example.exception.AunteficationException;

import java.util.List;

public interface UserBD {

    List<User> listAllUsers();

}

