package org.example.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    /*    инмктабал обьекты потоко безопасны при многопоточности чтобы изменить создаем новый обьект
     */
    private final String userName;
    private final int idSessions;
    private final byte[] passwordHash;
    private final List<User> contactList;

    public User(String userName, int idSessions, byte[] passwordHash) {
        this.userName = userName;
        this.idSessions = idSessions;
        this.passwordHash = passwordHash;
        this.contactList = new ArrayList<>();
    }
    public User changeName(String newName){
        return new User(newName,this.idSessions,this.passwordHash);
    }

    public String getUserName() {
        return userName;
    }

    public int getIdSessions() {
        return idSessions;
    }

    public byte[] getPasswordHash() {
        return passwordHash;
    }

    public List<User> getContactList() {
        return contactList;
    }
    public void addUsersToContactList(User...users){
        this.contactList.addAll(Arrays.asList(users));
    }
}
