public abstract class Person {

    private String id;
    private boolean isSignedIn;

    public abstract Message[] showAllMessages();  //Has to return a Message[]

}
