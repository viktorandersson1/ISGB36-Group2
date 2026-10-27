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

    public void showOwnMessages(){
        if(currentUser == null){
            System.out.println("You are not signed in.");
            return;
        }

        Message[] myMessages = currentUser.showOwnMessages();
        if(myMessages == null || myMessages.length == 0){
            System.out.println("You haven't posted any messages");
        }else{
            for(Message m: allMessages){
                System.out.println(m.toString());
            }
        }

    }

    public void postMessages (String content){
        if(currentUser != null){
            Message newMessage = currentUser.writMessage(content);

            String realID = "M" + (allMessages.size() + 1);
            newMessage.setMessageId(realID);

            allMessages.add(newMessage);
            currentUser.postMessage(newMessage);

            System.out.println("Message posted!");
        }else{
            System.out.println("You must be logged in to post a Message");
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

                Message[] userMessages = currentUser.getMessages();
                Message [] newArray = new Message[userMessages.length -1];
                int index = 0;

                for (Message m: userMessages){
                    if(!m.getMessageId().equals(msjID)){
                        if(index < newArray.length){
                            newArray[index++] = m;
                        }
                    }
                }
                currentUser.setMessages(newArray);
                currentUser.deleteMessage(msjID);
                System.out.println("Message deleted");
            }else{
                System.out.println("Unable to find message");
            }
        }else{
            System.out.println("You must be logged in to delete a Message.");
        }
    }

    public void showAllMEssages(){
        if(allMessages == null || allMessages.isEmpty()){
           System.out.println("No messages");
           return;
        }
        
        for(Message m: allMessages){
           System.out.println(m.toString());
        }
    }
}
