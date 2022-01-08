public class RoomCustomer extends Customer{
    private double rbill;
    private Room r;
//    private int bookStatus;


    @Override
    void viewTotalBill() {
        this.rbill = this.r.getRent();
        System.out.println("Bill: "+this.rbill);
    }

    @Override
    void allocateRoom(Room r1) {
        this.r = r1;
    }

    @Override
    void allocateDish(Dish d1) {

    }

    @Override
    void checkout() {
        System.out.println("Your Bill is: "+this.rbill);
        this.rbill=0;
        this.r.setStatus(0);
        System.out.println("Thank You! Visit Again.");
    }
}
