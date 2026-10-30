import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class AppController {
    private User currentUser;
    private List<User> users;
    private ConsoleUI view;

    // Claasss
    public void setView(ConsoleUI view) {
        this.view = view;
    }

    public AppController() {
        users = new ArrayList<>();
        currentUser = null;

        users.add(new User("Admin", "admin@admin.com", "1234"));
        users.add(new User("Roberto", "Roberto@gmail.com", "4321"));
        loadData();
    }

    public boolean login(String email, String password) {
        for (User u : users) {
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                currentUser = u;
                return true;
            }
        }
        return false;
    }

    public void logout() {
        currentUser = null;
    }

    public void showOwnMessages() {
        if (currentUser == null) {
            System.out.println("You are not signed in.");
            return;
        }

        Message[] myMessages = currentUser.showOwnMessages();
        view.displayMessages(myMessages);

    }

    public void postMessages(String content) {
        if (currentUser != null) {
            Message newMessage = currentUser.writeMessage(content);
            String realID = "M" + (Message.getAllMessages().length + 1);
            newMessage.setMessageId(realID);

            Message.saveMessage(newMessage);
            currentUser.postMessage(newMessage);

            saveData();

            System.out.println("Message posted!");
        } else {
            System.out.println("You must be logged in to post a Message");
        }

    }

    public void deleteMessage(String msjID) {
        if (currentUser != null) {
            Message deletedMsg = currentUser.deleteMessage(msjID);

            if (deletedMsg != null) {
                // If we found and eliminate, we eliminate also from the global arraymessages
                Message.deleteMessage(msjID);

                saveData();

                System.out.println("Message deleted successfully.");
            } else {
                System.out.println("Unable to find message or it is not yours.");
            }

        } else {
            System.out.println("You must be logged in to delete a Message.");
        }
    }

    public void showAllMEssages() {
        Message[] data = Message.getAllMessages();
        view.displayMessages(data);
    }

    private void loadData() {
        String file = "messages.csv";
        Scanner input = null;

        try {
            input = new Scanner(new File(file));
            int c = 0;

            while (input.hasNextLine()) {
                String line = input.nextLine();

                // Skip first line
                if (c == 0) {
                    c++;
                    continue;
                }

                String[] tokens = line.split("\t");
                if (tokens.length == 4) {
                    String id = tokens[0].trim();
                    String content = tokens[1].trim();
                    String authorEmail = tokens[2].trim();

                    Message m = new Message(id, content);
                    Message.saveMessage(m);

                    for (User u : users) {
                        if (u.getEmail().equals(authorEmail)) {
                            u.postMessage(m);
                            break;
                        }
                    }
                }
            }
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveData() {
        String fn = "messages.csv";
        PrintWriter writer = null;

        try {
            writer = new PrintWriter(new FileWriter(fn));
            writer.println("MessageID\tContent\tAuthorEmail\tDate");

            for (User u : users) {
                Message[] userMgs = u.showOwnMessages();
                if (userMgs != null) {
                    for (Message m : userMgs) {
                        writer.println(
                                m.getMessageId() + "\t" + m.getContent() + "\t" + u.getEmail() + "\t" + m.getDate());
                    }
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
