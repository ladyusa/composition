package email;


import java.util.List;
import java.util.Scanner;

public class EmailUI {
    private Scanner in;

    /**
     Constructs an EmailUI object.
     */
    public EmailUI() {
        in = new Scanner(System.in);
    }

    /**
     Runs the system.
     @param system the e-mail messaging system
     */
    public void run(EmailSystem system) {

        boolean more = true;
        String currentUser = null;

        System.out.println("=========== SWCon Email System ===========");

        while (more) {
            System.out.print(
                    "Command --> Log I)n  S)end message  R)ead messages  Log O)ut  Q)uit: ");
            String command = in.nextLine().toUpperCase();

            if ("I".equals(command)) {
                System.out.print("Username: ");
                currentUser = in.nextLine();
            }
            else if ("O".equals(command)) {
                currentUser = null;
            }
            else if ("Q".equals(command)) {
                more = false;
            }
            else if ("R".equals(command)) {
                if (currentUser == null || "".equals(currentUser)) {
                    System.out.println("Log in first!");
                }
                else {
                    System.out.println("************");
                    for (Email email : system.read(currentUser)) {
                        System.out.println(email);
                        System.out.println("************");
                    }
                }
            }
            else if ("S".equals(command)) {
                if (currentUser == null || "".equals(currentUser)) {
                    System.out.println("Log in first!");
                }
                else {
                    System.out.print("Enter recipient: ");
                    String to = in.nextLine();
                    System.out.print("Enter text: ");
                    String text = in.nextLine();
                    Email msg = new Email(currentUser, to, text);
                    system.send(msg);
                    System.out.println("Email to " + to + " is sent.");
                }
            }
        }
    }
}
