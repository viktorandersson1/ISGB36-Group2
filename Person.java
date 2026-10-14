public abstract class Person {

    private String id;
    private boolean isSignedIn;

    public abstract Message viewAllMessage();  //Has to return a Message[]

}
