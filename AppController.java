import java.util.ArrayList;
import java.util.List;

public class AppController {
    private User currentUser;
    private List<User> users;
    private ConsoleUI view;

    public void setView(ConsoleUI view){
        this.view = view;
    }

    public AppController(){
        users = new ArrayList<>();
        currentUser = null;

        users.add(new User("Admin", "admin@admin.com", "1234"));
        users.add(new User("Roberto", "Roberto@gmail.com", "4321"));
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

    public void logout(){
        currentUser = null;
    }

    public void showOwnMessages(){
        if(currentUser == null){
            System.out.println("You are not signed in.");
            return;
        }

        Message[] myMessages = currentUser.showOwnMessages();
        view.displayMessages(myMessages);

    }

    public void postMessages (String content){
        if(currentUser != null){
            Message newMessage = currentUser.writteMessage(content);
            String realID = "M" + (Message.getAllMessages().length + 1);
            newMessage.setMessageId(realID);

            Message.saveMessage(newMessage);
            currentUser.postMessage(newMessage);

            System.out.println("Message posted!");
        }else{
            System.out.println("You must be logged in to post a Message");
        }

    }

    public void deleteMessage(String msjID){
        if(currentUser != null){
            Message deletedMsg = currentUser.deleteMessage(msjID);
            
            if(deletedMsg != null){
                // If we found and eliminate, we eliminate also from the global arraymessages
                Message.deleteMessage(msjID);
                System.out.println("Message deleted successfully.");
            } else {
                System.out.println("Unable to find message or it is not yours.");
            }
            
        } else {
            System.out.println("You must be logged in to delete a Message.");
        }
    }

    public void showAllMEssages(){
        Message [] data = Message.getAllMessages();
        view.displayMessages(data);
    }
}
