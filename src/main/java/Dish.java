public class Dish {
    private String dishName;
    private double price;
    private String dishType;

    public Dish(String dishName, double price, String dishType) {
        this.dishName = dishName;
        this.price = price;
        this.dishType = dishType;
    }

    public String getDishName() {
        return dishName;
    }

    public double getPrice() {
        return price;
    }

    public String getDishType() {
        return dishType;
    }
}