package a2;

public class Drink {
    private String name;
    private int quantity;
    private int drinkNum;
    private static int drinkCount = 1;

    Drink(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.drinkNum = drinkCount;
        drinkCount += 1;
        if (drinkCount > 1000) {
            drinkCount = 1;
        }
    }

    @Override
    public String toString() {
        return "Drink #" + drinkNum + " ---> " +
                "name=" + name + " && " +
                "quantity=" + quantity;
    }

    String getName() {
        return name;
    }

    int getQuantity() {
        return quantity;
    }

    void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    int getDrinkNum() {
        return drinkNum;
    }
}
