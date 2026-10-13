public class User extends Person{
    private String name;
    private String email;
    private String password;
    private Message message;

    public User(String name, String email, String password, String messageId){
        this.name=name;
        this.email=email;
        this.password=password;
        message = new Message(messageId);
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

}
