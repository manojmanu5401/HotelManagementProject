import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
//        Room room;
        Scanner scan = new Scanner(System.in);
//        String dname;
        SelectEmployee selectEmployee;
        Restaurant restaurant = new Restaurant();
        Hotel dolphin = Hotel.getHotel();
        List<Dish> dishe = List.of(
                new Dish("Chocolate_Fondue   ",140,"Desert"),
                new Dish("Manchow_Soup       ",110,"Soup"),
                new Dish("Shahi_Paneer       ",220,"Main Course"),
                new Dish("Arizona_Tea        ",100,"Beverage"),
                new Dish("Salad              ",180,"Salad"),
                new Dish("Mushroom_Manchurian",170,"Starter"),
                new Dish("Pina_Colada        ",210,"Cocktail"),
                new Dish("Raspberry_Ripple   ",120,"Ice Cream")
        );
        restaurant.dishes.addAll(dishe); //adding all the dishes
        dolphin.setRestaurant(restaurant);
        List<Room> rooms = List.of(
                new Room("Deluxe",2,3500,1),
                new Room("AC    ",1,5500,2),
                new Room("Non AC",2,2500,3),
                new Room("AC    ",2,3500,4),
                new Room("Deluxe",2,3500,5),
                new Room("Deluxe",3,4500,6)
        );
        dolphin.setHotel(restaurant,rooms);
        level2:
        while(true){
                System.out.println("Enter your choice:");
                System.out.println("1. Accommodation");
                System.out.println("2. Restaurant");
                System.out.println("3. Exit");
                String ch = scan.nextLine();
                if(ch.equals("1")){
                    dolphin.customers.add(new RoomCustomer());
                    dolphin.generateID(dolphin.customers.get(dolphin.customers.size()-1));
                    System.out.println("Enter your details:");
                    dolphin.customers.get(dolphin.customers.size()-1).setData();
                    level1:
                        while (true) {
                            System.out.println("Enter your choice:");
                            System.out.println("1. To Display Available Rooms");
                            System.out.println("2. To Book a Room");
                            System.out.println("3. To Vacate Room");
                            System.out.println("4. To Get Invoice");
                            System.out.println("5. Call Room Service");
                            System.out.println("6. Go Back");
                            String ch2 = scan.nextLine();
                            switch (ch2) {
                                case "1":
                                    dolphin.displayAvailble();
                                    continue level1;
                                case "2":
                                    if (dolphin.customers.get(dolphin.customers.size()-1).getStatus() == 1) {
                                        System.out.println("Sorry! You Cannot Book more than one room!");
                                    }
                                    else {
                                        dolphin.customers.get(dolphin.customers.size()-1).setStatus(1);
                                        dolphin.displayAvailble();
                                        System.out.println("Enter Room no.");
                                        int rno = Integer.parseInt(scan.nextLine());
                                        dolphin.bookRoom(rno);
                                        Room r = dolphin.getRoom(rno);
                                        dolphin.customers.get(dolphin.customers.size()-1).allocateRoom(r);
                                        System.out.println("Room booked and your Unique ID is: "+dolphin.customers.get(dolphin.customers.size()-1).getCustID());
                                    }
                                    continue level1;
                                case "3":
                                    if(dolphin.customers.get(dolphin.customers.size()-1).getStatus()==0){
                                        System.out.println("Cannot vacate a room unless booked");
                                        continue level1;
                                    }
                                    else{
                                        dolphin.customers.get(dolphin.customers.size()-1).setStatus(0);
                                        System.out.println("Enter Room No.");
                                        int rno = Integer.parseInt(scan.nextLine());
                                        dolphin.vacateRoom(rno);
                                        System.out.println("Room vacated");
                                        continue level2;
                                    }
                                case "4":
                                    if(dolphin.customers.get(dolphin.customers.size()-1).getStatus()==0){
                                        System.out.println("Cannot get invoice details");
                                    }
                                    else{
                                        dolphin.customers.get(dolphin.customers.size()-1).printCustomer();
                                        dolphin.customers.get(dolphin.customers.size()-1).viewTotalBill();
                                    }
                                    continue level1;
                                case "5":
                                    if(dolphin.customers.get(dolphin.customers.size()-1).getStatus()==0){
                                        System.out.println("Cannot call Room Service Unless you book a Room");
                                    }
                                    else{
                                        selectEmployee = new SelectEmployee(new RoomService());
                                        selectEmployee.performDuty();
                                    }
                                    continue level1;
//                                case "5":
//                                    if(dolphin.customers.get(dolphin.customers.size()-1).getStatus()==0){
//                                        System.out.println("No Room booked");
//                                    }
//                                    else{
//                                        dolphin.customers.get(dolphin.customers.size()-1).setStatus(0);
//                                        System.out.println("Enter Room No.");
//                                        int rno = Integer.parseInt(scan.nextLine());
//                                        dolphin.vacateRoom(rno);
//                                        System.out.println("Cancellation successful");
//                                    }
//                                    continue level1;
                                case "6":
                                    continue level2;

                                default:
                                    throw new IllegalStateException("Unexpected value: " + ch2);
                            }
                        }
                }
                else if(ch.equals("2")){
                    dolphin.customers.add(new RestaurantCustomer());
                    dolphin.generateID(dolphin.customers.get(dolphin.customers.size()-1));
                    System.out.println("Enter your details:");
                    dolphin.customers.get(dolphin.customers.size()-1).setData();
                    level3:
                        while (true){
                            System.out.println("Enter your choice:");
                            System.out.println("1. To Display Menu");
                            System.out.println("2. To Order a Dish");
                            System.out.println("3. To Get Invoice");
                            System.out.println("4. To Cancel order");
                            System.out.println("5. Go Back");
                            String ch3 = scan.nextLine();
                            switch (ch3){
                                case "1":
                                    dolphin.displayMenu();
                                    continue level3;
                                case "2":
                                    if(dolphin.customers.get(dolphin.customers.size()-1).getStatus()==1){
                                        System.out.println("You cannot order more than one dish");
                                    }
                                    else {
                                        dolphin.displayMenu();
                                        selectEmployee = new SelectEmployee(new Waiter());
                                        selectEmployee.performDuty();
                                        System.out.println("Enter Dish Name you want to Order(Make sure you enter the exact same name.)");
                                        String dishName = scan.nextLine();
                                        if(dolphin.takeOrder(dishName)){
                                            dolphin.customers.get(dolphin.customers.size() - 1).setStatus(1);
                                            Dish dish = dolphin.getRestaurant().getDish(dishName);
                                            dolphin.customers.get(dolphin.customers.size() - 1).allocateDish(dish);
                                        }

                                    }
                                    continue level3;
                                case "3":
                                    if(dolphin.customers.get(dolphin.customers.size()-1).getStatus()==0){
                                        System.out.println("Cannot get invoice details");
                                    }
                                    else{
                                        dolphin.customers.get(dolphin.customers.size()-1).printCustomer();
                                        dolphin.customers.get(dolphin.customers.size()-1).viewTotalBill();
                                    }
                                    continue level3;
                                case "4":
                                    if(dolphin.customers.get(dolphin.customers.size()-1).getStatus()==0){
                                        System.out.println("No Dish ordered to cancel");
                                    }
                                    else{
                                        dolphin.customers.get(dolphin.customers.size()-1).setStatus(0);
                                        System.out.println("Order Canceled");
                                    }
                                    continue level3;
                                case "5":
                                    continue level2;
                            }
                        }
                }
                else if (ch.equals("3")) break;
                else{
                    System.out.println("Invalid Input");
                }

        }

    }
}
