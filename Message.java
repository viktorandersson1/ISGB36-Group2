import java.util.Arrays;
import java.util.Date;

public class Message{

    //Creates values 
    private String messageId;
    private String content;
    private Date publisherDate;
    
    public Message(String messageId, String content){
        setMessageId(messageId);
        setContent(content);
        publisherDate = new Date();
    }

    private static Message[] allMessages = new Message[0];
    public static Message[] getAllMessages (){
        return allMessages;
    }

    public static void saveMessage(Message m){
        allMessages = Arrays.copyOf(allMessages, allMessages.length + 1);
        allMessages[allMessages.length - 1] = m;
    }

    public static void deleteMessage(String id){
        int indexToremove = -1;

        // We search  the position where the message is
        for (int i = 0; i < allMessages.length; i++) {
            if (allMessages[i].getMessageId().equals(id)) {
                indexToremove = i;
                break;
            }
        }

        // if we found it, create a small new array and copy the rest
        if (indexToremove != -1) {
            Message[] newArray = new Message[allMessages.length - 1];
            int j = 0;
            for (int i = 0; i < allMessages.length; i++) {
                if (i != indexToremove) {
                    newArray[j++] = allMessages[i];
                }
            }
            allMessages = newArray; // We replaced the old array with the new one
        }
    }

    public String getMessageId(){
        return messageId;
    }

    public void setMessageId(String messageId){
        this.messageId = messageId;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public Date getDate(){
        return publisherDate;
    }

    public void setDate(Date date){
        this.publisherDate = date;
    }

    public String toString(){
        return messageId + ", " + content + ", " + publisherDate;
    }
}