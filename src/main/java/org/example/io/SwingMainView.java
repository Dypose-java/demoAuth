package org.example.io;

import org.example.data.MessageRepository;
import org.example.domain.Message;
import org.example.domain.User;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SwingMainView implements MainView {
    private static final int NUM_COLUMNS_FOR_CONTACTS = 2;
    private final MessageRepository messageRepository;
    private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

    public SwingMainView(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void showError(Throwable throwable) {
        JOptionPane.showMessageDialog(null,
                throwable.getMessage(),
                APP_NAME,
                JOptionPane.ERROR_MESSAGE
                    ,LAST_ICON);
    }


    @Override
    public void showMainFrame(User user) {
        List<User> contactList = user.getContactList();
        List<Message> allMessagesForMe = messageRepository.getAllMessages(user);

        String messageHistroy = allMessagesForMe.stream().sorted(Comparator.comparing(Message::getCreationDate))
                .map(message -> "сообщение от " + message.getFrom() +
                        " (" + dateFormat.format(message.getCreationDate()) + ");"
                        + "\n"
                        + message.getText()).collect(Collectors.joining("\n\n"));

        JFrame frame = new JFrame();
        JTextArea textArea =  new JTextArea(50,1);
        JTable contactsTable = new JTable(contactList.size(), NUM_COLUMNS_FOR_CONTACTS);
        textArea.append(messageHistroy);
    }

    @Override
    public void startMessage(User user) {

    }
}
