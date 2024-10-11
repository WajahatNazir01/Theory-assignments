import java.util.Scanner;
public class MessagingApp {
    public Sms[][] chats = new Sms[100][50];
    int[] chatCount = new int[100];
    public String[][] contacts = new String[100][2];
    private int[] messageIdCounter=new int[100];
    static int countContact = 0;

    public void addContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter receiver's name:");
        String name1 = sc.nextLine();
        System.out.println("Enter number:");
        String number1 = sc.nextLine();
        String[] existingContact = findContactByName(name1);
        if (countContact < contacts.length) {
            contacts[countContact][0] = name1; // Name
            contacts[countContact][1] = number1; // Number
            System.out.println("Contact added...");
            countContact++;
        } else {
            System.out.println("Contact list is full.");
        }
    }

    public void viewContactList() {
        if (countContact == 0) {
            System.out.println("No contact found!!");
            return;
        }
        System.out.println("CONTACT LIST:");
        for (int i = 0; i < countContact; i++) {
            System.out.println("Name : " + contacts[i][0] + " | Number :" + contacts[i][1]);
        }
    }

    public void deleteContact() {
        Scanner sc = new Scanner(System.in);
        boolean contactFound = false;
        System.out.println("Enter contact name:");
        String name1 = sc.nextLine();
        for (int i = 0; i < countContact; i++) {
            if (contacts[i][0].equalsIgnoreCase(name1)) {
                contacts[countContact - 1] = null;//this line removes the last contact
                countContact--;
                System.out.println("Contact " + name1 + " deleted successfully...");
                contactFound = true;
                return;
            }
        }
        if (!contactFound) {
            System.out.println("Contact not found!!!");
        }
    }

    public void sendMessage(String receiverName) {
        int contactIndex = findContactIndexByName(receiverName); //  the index of the receiver's name
        if (contactIndex != -1) {
            messageIdCounter[contactIndex]++;
            String messagId=String.format("%03d",messageIdCounter[contactIndex]);
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter message:");
            String smsContent = sc.nextLine();
            Sms sms = new Sms(receiverName, smsContent);
            chats[contactIndex][chatCount[contactIndex]] = sms;
            chatCount[contactIndex]++;
            System.out.println("Message sent successfully");
        } else {
            System.out.println("Contact not found!!!");
        }
    }



    public void displaychats(String receiverName) {
        int contactIndex = findContactIndexByName(receiverName);

        if (contactIndex != -1) {
            for (int i = 0; i < chatCount[contactIndex]; i++) {
                System.out.println(chats[contactIndex][i].toString());
                chats[contactIndex][i].markAsRead();
            }
            if (chatCount[contactIndex] == 0) {
                System.out.println("No messages found for this contact.");
            }
        } else {
            System.out.println("Contact not found...!");
        }
    }

    public void deleteMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter contact name:");
        String contactName = sc.nextLine();
        int contactIndex = findContactIndexByName(contactName);

        if (contactIndex != -1) {
            System.out.println("Enter message ID to delete:");
            String messageId = sc.nextLine();

            Sms messageToDelete = findMessageById(contactIndex, messageId);
            if (messageToDelete != null) {
                for (int i = 0; i < chatCount[contactIndex]; i++) {
                    if (chats[contactIndex][i].getMessageId().equals(messageId)) {
                        chats[contactIndex][chatCount[contactIndex] - 1] = null;
                        chatCount[contactIndex]--;
                        System.out.println("Message with ID " + messageId + " deleted successfully.");
                        break;
                    }
                }
            } else {
                System.out.println("Message not found!!!");
            }
        } else {
            System.out.println("Contact not found!!!");
        }
    }

    public void searchMessageById() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter contact name:");
        String contactName = sc.nextLine();
        int contactIndex = findContactIndexByName(contactName);

        if (contactIndex != -1) {
            System.out.println("Enter message ID to search:");
            String messageId = sc.nextLine();

            Sms message = findMessageById(contactIndex, messageId);
            if (message != null) {
                System.out.println("Message found: " + message.toString());
            } else {
                System.out.println("Message not found with ID: " + messageId);
            }
        } else {
            System.out.println("Contact not found!!!");
        }
    }




    private int findContactIndexByName(String name) {
        for (int i = 0; i < countContact; i++) {
            if (contacts[i][0].equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    private String[] findContactByName(String name) {
        for (int i = 0; i < countContact; i++) {
            if (contacts[i][0].equalsIgnoreCase(name)) {
                return contacts[i];
            }
        }
        return null;
    }
    private Sms findMessageById(int contactIndex, String messageId) {
        for (int i = 0; i < chatCount[contactIndex]; i++) {
            if (chats[contactIndex][i].getMessageId().equals(messageId)) {
                return chats[contactIndex][i];
            }
        }
        return null;
    }
}
