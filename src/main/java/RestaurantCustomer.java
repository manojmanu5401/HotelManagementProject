public class RestaurantCustomer extends Customer{
    private double dbill;
    private Dish d;
    private int orderStatus;

    @Override
    void viewTotalBill() {
        this.dbill = this.d.getPrice();
        System.out.println("Bill: "+this.dbill);
    }

    @Override
    void allocateRoom(Room r1) {

    }
    @Override
    void allocateDish(Dish d1) {
        this.d =d1;
        System.out.println(this.d.getPrice());
    }

    @Override
    void checkout() {
    }

    public void printCustomer(){
        super.printCustomer();
        if(orderStatus==1){
            System.out.println("Dish Name:"+d.getDishName());
            System.out.println("Dish Type:"+d.getDishType());
        }
    }

}
