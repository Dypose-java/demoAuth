package org.example.data;

import org.example.domain.Message;
import org.example.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    //оборачивыем в оптионал чтобы не словить null лучше получить пустой обьект чем null
   Optional<User> findUserByUserName(String userName);
   Optional<User> findUserByIdSessions(String userName);

}
