package org.example.data;

import org.example.domain.Message;
import org.example.domain.User;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MockMessageRepository implements MessageRepository {
    @Override
    public List<Message> getAllMessages(User user) {
        //new User("Dypose",52,new SecurityService().calculateHash(pas));
        //Integga 1337
        //Kozha 228
        Message msgFromIntegga0 = new Message("hello worl",1337,52,yesterdayDate());
        Message msgFromIntegga1 = new Message("Белорус",1337,52,yesterdayDate());
        return List.of(msgFromIntegga0,msgFromIntegga1);
    }


    @Override
    public void sendMessage(User user, Message message) {

    }
    public Date yesterdayDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_WEEK,-1);
        return calendar.getTime();
    }


}
