public interface UserInterface extends Interface{
    public Message deleteMessage();
    public boolean checkSignedIn(boolean isSigned);
    public void postMessage();
    public Message [] viewAllMessage();
    public Message [] viewOwnMessages();
}
