import java.util.ArrayList;
import java.util.List;

public class AppController {
    private User currentUser;
    private List<User> users;
    private List<Message> allMessages; //Move to Guest class

    public AppController(){
        users = new ArrayList<>();
        allMessages = new ArrayList<>();
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

    public String getOwnMessages(){
        if(currentUser == null){
            return "You are not signed in.";
        }

        Message[] myMessages = currentUser.getMessages();
        if(myMessages == null || myMessages.length == 0){
            return "You haven't posted any messages";
        }else{
            String text = "";
            for(Message m: allMessages){
                text += m.toString() + "\n";
            }
            return text;
        }

    }

    public void postMessages (String content){
        if(currentUser != null){
            String id = "M" + (allMessages.size() + 1);
            Message newMessage = new Message(id, content);

            allMessages.add(newMessage);
            currentUser.addMessage(newMessage);

            System.out.println("Message posted!");
        }

    }

    public void deleteMessage(String msjID){
        if(currentUser != null){
            Message messageToRemove = null;
            
            for (Message m: allMessages){
                if(m.getMessageId().equals(msjID)){
                    messageToRemove = m;
                    break;
                }
            }

            if(messageToRemove != null){
                allMessages.remove(messageToRemove);
                System.out.println("Message deleted");
            }else{
                System.out.println("Unable to find message");
            }

        }
    }

    public String getAllMEssages(){
        if(allMessages == null || allMessages.isEmpty()){
            return "No messages";
        }
        String text = "";
        for(Message m: allMessages){
           text = text + m.toString() + "\n";
        }

        return text;
    }
}
