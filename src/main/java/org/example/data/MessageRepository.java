package org.example.data;

import org.example.domain.Message;
import org.example.domain.User;

import java.util.List;

public interface MessageRepository {
    List<Message> getAllMessages(User user);
    void sendMessage(User user,Message message);
}

