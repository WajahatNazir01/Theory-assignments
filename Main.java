
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        MessagingApp m1 = new MessagingApp();
        while(true){
            System.out.println("Enter 1 to add contact :");
            System.out.println("Enter 2 to view contact list:");
            System.out.println("Enter 3 to delete contact:");
            System.out.println("Enter 4 to send message:");
            System.out.println("Enter 5 to display chats:");
            System.out.println("Enter 6 to delete specific message by message id:");
            System.out.println("Enter 7 to search message by Id");
            System.out.println("Enter 8 to exit:");

            Scanner sc1=new Scanner(System.in);
            int choice1=sc1.nextInt();
            switch (choice1){
                case 1:{
                  m1.addContact();
                    break;
                }
                case 2:{
                    m1.viewContactList();
                    break;
                }
                case 3:{
                  m1.deleteContact();
                    break;
                }
                case 4:{
                    Scanner sc=new Scanner(System.in);
                    System.out.println("Enter receiver name:");
                    String rn1=sc.nextLine();

                    m1.sendMessage(rn1);
                    break;
                }
                case 5:{
                    Scanner sc=new Scanner(System.in);
                    System.out.println("Enter receiver's name:");
                    String rn1=sc.nextLine();
                    m1.displaychats(rn1);
                    break;
                }
                case 6:{
                    m1.deleteMessage();
                    break;
                }
                case 7:{
                    m1.searchMessageById();
                    break;
                }
                case 8:{
                    System.out.println("PROGRAM ENDED...");
                    return;
                }
            }
        }
    }


}