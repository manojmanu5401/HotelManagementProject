import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hotel {
    private static Hotel instance;
    private String hotelName;
    private String hotelAddress;
    private Restaurant restaurant;
    public List<Room> room = new ArrayList<>();
    public List<Customer> customers = new ArrayList<>();

    public static Hotel getInstance() {
        return instance;
    }

    public static void setInstance(Hotel instance) {
        Hotel.instance = instance;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Room> getRoom() {
        return room;
    }

    private Hotel(){}
    public static synchronized Hotel getHotel(){
        if(instance == null){
            instance = new Hotel();
        }
        return instance;
    }

    public void setHotel(Restaurant r,List<Room> rs){
        for(int i=0;i<6;i++){
            this.room.add(rs.get(i));
        }
        for(int i=0;i<8;i++){
            this.restaurant.dishes.set(i,r.dishes.get(i));
        }
    }

    public void generateID(Customer c){
        String id = String.valueOf(new Random().nextInt(1000));
        c.setCustID(id);
    }
    public Room getRoom(int rno){
        for(Room r:room){
            if(r.getRoomNo() == rno){
                return r;
            }
        }
        return null;
    }
    public void displayAvailble(){
        System.out.println("---------------------------------------------Room Details----------------------------------------------");
        System.out.println("Room Type"+"     "+"Number of Beds"+"     "+"Rent"+"     "+"Room Number");
        for(Room r: room){
            if(r.getStatus() ==0){
                System.out.println(r.getRoomType()+"               "+r.getNoOfBeds()+"            "+r.getRent()+"             "+r.getRoomNo());
            }
        }
    }

    public void displayMenu(){
        System.out.println("----------------------------------------------Menu-------------------------------------------------");
        System.out.println("Dish Name"+"                            "+"Price"+"                        "+"Dish Type");
        for(Dish d: restaurant.dishes){
            System.out.println(d.getDishName()+"                "+d.getPrice()+"                "+d.getDishType());
        }
    }

    public void bookRoom(int r){
        for(Room room:room){
            if(room.getRoomNo()==r){
                room.setStatus(1);
            }
        }
    }
    public void vacateRoom(int rno){
        int j=0;
        for(Room room:room){
            if(room.getRoomNo()==rno){
                j=1;
                room.setStatus(0);
                System.out.println("Thank You! Visit Again.");
                break;
            }
        }
        if(j==0){
            System.out.println("Sorry Room not found, or occupied at the moment");
        }
    }

    public boolean takeOrder(String dnm){
        int j=0;
        for(Dish d:restaurant.dishes){
            if(d.getDishName().replaceAll("\\s","").equals(dnm)){
                j=1;
                System.out.println("Order Successful");
                return true;
            }
        }
        if(j==0){
            System.out.println("Sorry! Dish Not Found, Enter a valid dish Name");
            return false;
        }
        return false;
    }



}
