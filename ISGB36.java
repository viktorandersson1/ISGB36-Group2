public class ISGB36 {
    
    public static void main(String[] args){
        
        //Test Message
        Message m1 = new Message("m1", "This is a message!");
        System.out.println(m1);

        Message m2 = new Message("m2", "This is another message!");

        //Test User
        User u1 = new User("Viktor Andersson", "v.a@gmail.com", "Password1234");
        

        u1.addMessage(m1);
        System.out.println(u1 + " :" + m1);

        System.out.println(u1);

       
    }

}
