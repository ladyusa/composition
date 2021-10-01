package email;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmailSystem {

    // composition
    private Map<String,Inbox> inboxes;

    public EmailSystem() {
        inboxes = new HashMap<>();
    }

    public void send(Email email) {
        String recipient = email.getRecipient();

        if (inboxes.get(recipient) == null)
            inboxes.put(recipient, new Inbox(recipient));

        Inbox recipientInbox = inboxes.get(recipient);
        recipientInbox.receive(email);
    }

    public List<Email> read(String owner) {
        Inbox ownerInbox = inboxes.get(owner);
        return ownerInbox.readAll();
    }
}

