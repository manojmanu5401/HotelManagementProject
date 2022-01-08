import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    public List<Dish> dishes= new ArrayList<>();

    public Dish getDish(String dishName){
        for(Dish d:dishes){
            if(d.getDishName().replaceAll("\\s","").equalsIgnoreCase(dishName)){
                return d;
            }
        }
        return null;
    }

    public void displayDish(Dish d){
        System.out.println("Dish Name: "+ d.getDishName());
        System.out.println("Price: "+ d.getPrice());
        System.out.println("Dish Type: "+ d.getDishType());
    }

    public void displayMenu(){
        for(Dish d:dishes){
            displayDish(d);
        }
    }
}
