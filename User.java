import java.util.ArrayList;
import java.util.Arrays;

public class User extends Person{
    private String name;
    private String email;
    private String password;
    private Message[] messages;

    public User(){super();}

    //Create a constructor including the id and isSignedIn when there is a constructor in Person.


    public User(String name, String email, String password){
        this.name=name;
        this.email=email;
        this.password=password;
        messages = new Message[0];
    }


    public void addMessage(Message m){
        messages = Arrays.copyOf(messages, messages.length+1);
        messages[messages.length-1] = m;
    }

    

    
    
    public Message viewAllMessage(){  // Has to return a ArrayList
        return null;
    }


    
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
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
       
        return name + ", " + email + ", " + password + ", " + Arrays.toString(messages);
    }

    

}
