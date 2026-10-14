public class ISGB36 {
    
    public static void main(String[] args){
        
        //Test Message
        Message m1 = new Message("m1", "This is a message!");
        //System.out.println(m1);

        //Test User
        User u1 = new User("Viktor Andersson", "v.a@gmail.com", "Password1234");
        //System.out.println(u1);

        u1.addMessage(m1);
        System.out.println(u1);



       
    }

}
