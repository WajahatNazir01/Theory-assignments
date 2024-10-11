
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Sms {
    private String messageId;
    private String senderName;
    private String receiver;
    private String content;
    private String status;
    public static int messageCounter=0;
    //private LocalDateTime timeStamp;
    LocalDateTime ldt=LocalDateTime.now();
    DateTimeFormatter dtf= DateTimeFormatter .ofPattern("dd/MM/yyyy_E_hh:mm:ss ");
    public String dateTime= ldt.format(dtf);


    public void markAsRead(){
        this.status="read";
    }

    //getter setter
    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }


    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getMessageId() {
        return messageId;
    }

    public Sms(String messageId, String senderName, String sms1) {
        this.messageId =String.format("%03d",++messageCounter);
        this.senderName = "Wajahat";
        this.receiver = receiver;
        this.content = content;
        this.status = "unread";
        this.dateTime=dateTime;
    }
    public Sms(String receiverName, String smsContent) {
        // Format current LocalDateTime to String
        String formattedDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy_E_HH:mm:ss"));

        this.messageId = String.format("%03d", ++messageCounter); // Generate messageId
        this.senderName = "Wajahat"; // Default sender name
        this.receiver = receiverName; // Receiver from parameter
        this.content = smsContent; // Content from parameter
        this.status = "unread"; // Set status to "unread"
        this.dateTime = formattedDateTime; // Set dateTime
    }



    @Override
    public String toString() {

        return String.format("MesageId: %s\nFrom: %s\nTo: %s\nStatus: %s\nContent: %s\nTime: %s\n",messageId,senderName,receiver,status,content,dateTime);
    }

    @Override
    public boolean equals(Object o){
        Sms that=(Sms)o;
        return this.messageId.equals(that.messageId) || this.senderName.equals(that.senderName);
    }

}
