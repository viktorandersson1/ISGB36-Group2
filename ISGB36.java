public class ISGB36 {
    
    public static void main(String[] args){
        
        AppController controller = new AppController();
        ConsoleUI ui = new ConsoleUI(controller);

        ui.start();

    }
}
        /*
        
        //Test Message
        Message m1 = new Message("m1", "This is a message!");
        //System.out.println(m1);
        Message m2 = new Message("m2", "This is another message!");

        //Test User
        User u1 = new User("Viktor Andersson", "v.a@gmail.com", "Password1234");
        
        User u2 = new User("John Smith", "john.smith@gmail.com", "password4321");

        u1.addMessage(m1);
        u2.addMessage(m2);
        //System.out.println(u1 + " :" + m1);
        */

       