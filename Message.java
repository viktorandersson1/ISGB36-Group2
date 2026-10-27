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