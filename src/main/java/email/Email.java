package email;

public class Email {
    private String sender;
    private String recipient;
    private String text;

    public Email(String from, String to, String text) {
        sender = from;
        recipient = to;
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    @Override
    public String toString() {
        return "From: " + sender + "\n" +
                "To: " + recipient + "\n" +
                text;
    }
}

