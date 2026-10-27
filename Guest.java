public class Guest extends Person{
    
    @Override
    public Message[] showAllMessages() {
        return new Message[0];
    }

    public boolean checkSignedIn(boolean isSignedIn){
        return isSignedIn;
    }

}
