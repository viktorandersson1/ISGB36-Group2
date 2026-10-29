import java.util.Arrays;

public class User extends Person{
    private String name;
    private String emailAdress;
    private String password;
    private Message[] messages;

    public User(){super();}

    //Create a constructor including the id and isSignedIn when there is a constructor in Person.


    public User(String name, String email, String password){
        this.name=name;
        this.emailAdress=email;
        this.password=password;
        messages = new Message[0];
    }

    @Override 
    public Message[] showAllMessages(){
        return null;  //The controler do the operation
    }

    public boolean checkSignedIn(boolean isSignedIn){
        return isSignedIn;
    }
    
    public Message[] showOwnMessages(){
        return this.messages;
    }

    public Message writeMessage(String content){
        return new Message("TempID", content);
    }
    
    public Message postMessage(Message m){
        messages = Arrays.copyOf(messages, messages.length+1);
        messages[messages.length-1] = m;
        return m;
    }

    public Message deleteMessage(String messageID){
        Message messageToRemove = null;
        int indexToRemove = -1;
        
        // Search the message in usermessages
        for (int i = 0; i < messages.length; i++) {
            if (messages[i].getMessageId().equals(messageID)) {
                messageToRemove = messages[i];
                indexToRemove = i;
                break;
            }
        }

        // If we found we eliminate of usermessages
        if (indexToRemove != -1) {
            Message[] newArray = new Message[messages.length - 1];
            int j = 0;
            for (int i = 0; i < messages.length; i++) {
                if (i != indexToRemove) {
                    newArray[j++] = messages[i];
                }
            }
            messages = newArray;
        }
        return messageToRemove; 
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getEmail(){
        return emailAdress;
    }

    public void setEmail(String email){
        this.emailAdress=email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public Message[] getMessages(){
        return messages;
    }

    public void setMessages(Message[] messages){
        this.messages = messages;
    }

    public String toString(){
        return name + ", " + emailAdress + ", " + password + ", " + Arrays.toString(messages);
    }



    

}
