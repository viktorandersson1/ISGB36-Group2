import java.util.Date;

public class Message{

    //Creates values 
    private String messageId;
    private String content;
    private Date date;
    
    public Message(String messageId, String content){
        setMessageId(messageId);
        setContent(content);
        date = new Date();
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
        return date;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public String toString(){
        return content + " " + date + "\n";
    }
}