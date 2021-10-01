package email;

import java.util.ArrayList;
import java.util.List;

public class Inbox {

    // composition
    private String user;
    private ArrayList<Email> emailList;

    public Inbox(String user) {
        this.user = user;
        this.emailList = new ArrayList<>();
    }

    public void receive(Email email) {
        emailList.add(email);
    }

    public List<Email> readAll() {
        return emailList;
    }

    public String getUser() {
        return user;
    }
}

