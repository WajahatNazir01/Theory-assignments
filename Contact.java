public class Contact {
    private String name;
    private String number;
   // static int idCount=0;
//getter abd setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    //constructor

    public Contact(String id, String name, String number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("Contact Name: %s  |  Number: %s\n",name,number);
    }
}
