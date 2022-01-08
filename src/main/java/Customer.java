import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

abstract class Customer {

    private String custName;
    private String custAddress;
    private String custID;
    private long custPhone;
    private String custEmail;
    private String checkInTime;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

//    public Map<String,Customer> customerMap = new HashMap<String,Customer>();

    public Customer(){
        this.custName = "";
        this.custAddress="";
        this.custPhone=0L;
        this.custID="";
        this.custEmail="";
        this.checkInTime = LocalDateTime.now().toString();
        status =0;
    }

    public void setData(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your name: ");
        this.custName = scan.nextLine();
        System.out.println("Enter your address: ");
        this.custAddress = scan.nextLine();
        System.out.println("Enter your PhoneNumber: ");
        this.custPhone = Long.parseLong(scan.nextLine());
        System.out.println("Enter your Email: ");
        this.custEmail = scan.nextLine();
        this.checkInTime = LocalDateTime.now().toString();
//        customerMap.put(custID,this);
    }

    public void printCustomer(){
        System.out.println("Customer ID: "+this.custID);
        System.out.println("Name: "+this.custName);
        System.out.println("Address: "+this.custAddress);
        System.out.println("Phone: "+this.custPhone);
        System.out.println("Email: "+this.custEmail);
        System.out.println("Check-In-time: "+this.checkInTime);
    }

    abstract void viewTotalBill();

    abstract void allocateRoom(Room r1);

    abstract void allocateDish(Dish d1);

    abstract void checkout();
}
